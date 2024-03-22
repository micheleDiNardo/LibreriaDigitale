package com.example.LibreriaDigitale.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibreriaDigitale.services.AutorizzazioneService;
import com.example.LibreriaDigitale.login.LoginRequest;
import com.example.LibreriaDigitale.login.TokenManager;
import com.example.LibreriaDigitale.models.Utente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ControllerUtente {

    @Autowired
    private AutorizzazioneService autoService;

    @PostMapping("/login")
    public ResponseEntity<?> loginEmail(@RequestBody LoginRequest loginRequest) {

        Utente utente = autoService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (utente != null) {
            String token = TokenManager.generatoreToken(utente);
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("idUtente", utente.getId_utente());
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.badRequest().body("Credenziali non valide");
    }

}
