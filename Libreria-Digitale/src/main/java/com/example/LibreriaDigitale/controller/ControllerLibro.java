package com.example.LibreriaDigitale.controller;

import java.util.List;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.LibreriaDigitale.login.TokenManager;
import com.example.LibreriaDigitale.models.Libro;
import com.example.LibreriaDigitale.models.Utente;
import com.example.LibreriaDigitale.services.LibreriaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/libreria")
public class ControllerLibro {

    @Autowired
    private LibreriaService libroService;

    @GetMapping("/catalogo")
    public List<Libro> vediTuttiLibri() {
        return libroService.ottieniTuttiLibri();
    }

    @PostMapping("/add/libro")
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

    @GetMapping("/libri/utente")
    public ResponseEntity<Set<Libro>> vediLibriPerUtente(
            @RequestParam("idUtente") Integer idUtente,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        Set<Libro> libriUtente = libroService.vediLibriPerUtente(idUtente);
        return ResponseEntity.ok(libriUtente);
    }

    @DeleteMapping("/rimuoviLibro")
    public ResponseEntity<String> eliminaLibri(
            @RequestParam("idUtente") Integer idUtente,
            @RequestParam("idLibro") Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        libroService.rimuoviLibroPerUtente(idUtente, idLibro);

        return ResponseEntity.ok("libro con id : " + idLibro + "rimosso all'utente con id: " + idUtente);
    }

    @PutMapping("modifica")
    public ResponseEntity<String> modifcaLibro(
            @RequestParam("idLibro") Integer idLibro,
            @RequestBody Libro libroAggiornato,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        libroService.modificaLibro(idLibro, libroAggiornato);

        return ResponseEntity.ok("modificato correttamente il libro con id : " + idLibro);
    }

    @PutMapping("lettura/{idLibro}")
    public ResponseEntity<String> aumentaNumeroLetture(
            @PathVariable Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        libroService.incrementaNumeroLetture(idLibro);

        return ResponseEntity.ok("il numero di letture è stato incrementato");
    }

}
