package com.example.LibreriaDigitale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibreriaDigitale.models.Utente;
import com.example.LibreriaDigitale.repository.UtenteRepository;

@Service
public class AutorizzazioneService {

    @Autowired
    private UtenteRepository utenteRepo;

    public Utente login(String email, String password) {
        Utente utente = utenteRepo.findByEmail(email);

        if (utente != null && utente.getPassword().equals(password)) {
            return utente;
        }
        return null;
    }

}
