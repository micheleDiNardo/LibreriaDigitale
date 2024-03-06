package com.example.LibreriaDigitale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibreriaDigitale.services.AutorizzazioneService;
import com.example.LibreriaDigitale.login.LoginRequest;
import com.example.LibreriaDigitale.login.TokenManager;
import com.example.LibreriaDigitale.models.Utente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {

    @Autowired
    private AutorizzazioneService autoService;

    @PostMapping("/login")
    public ResponseEntity<String> loginEmail(@RequestBody LoginRequest loginRequest) {

        Utente utente = autoService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (utente != null) {
            String token = TokenManager.generatoreToken(utente);
            return ResponseEntity.ok().body(token);
        }

        return ResponseEntity.badRequest().body("Credenziali non valide");

    }

}
