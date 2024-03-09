package com.example.LibreriaDigitale.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibreriaDigitale.models.Libro;
import com.example.LibreriaDigitale.models.Utente;
import com.example.LibreriaDigitale.repository.LibroRepository;
import com.example.LibreriaDigitale.repository.UtenteRepository;

@Service
public class LibreriaService {

    @Autowired
    private LibroRepository libroRepo;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Libro> ottieniTuttiLibri() {
        return libroRepo.findAll();
    }

    public void aggiungiLibroPerUtente(Integer idUtente, Integer idLibro) {
        Utente utente = utenteRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Libro libro = libroRepo.findById(idLibro).orElseThrow(() -> new RuntimeException("Libro non trovato"));

        utente.aggiungiLibro(libro);
        utenteRepository.save(utente);

    }

}