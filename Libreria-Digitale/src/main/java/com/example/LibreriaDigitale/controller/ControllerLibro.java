package com.example.LibreriaDigitale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.LibreriaDigitale.login.TokenManager;
import com.example.LibreriaDigitale.models.Libro;
import com.example.LibreriaDigitale.services.LibreriaService;

@RestController
@RequestMapping("api/libreria")
public class ControllerLibro {

    @Autowired
    private LibreriaService libroService;

    @GetMapping("/catalogo")
    public List<Libro> vediTuttiLibri() {
        return libroService.ottieniTuttiLibri();
    }

    @PostMapping("/leggiLibro")
    public ResponseEntity<String> aggiungiLeggiLibro(
            @RequestParam("idUtente") Integer idUtente,
            @RequestParam("idLibro") Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        libroService.aggiungiLibroPerUtente(idUtente, idLibro);

        return ResponseEntity.ok("libro aggiunto all'utente con id: " + idUtente);

    }

}
