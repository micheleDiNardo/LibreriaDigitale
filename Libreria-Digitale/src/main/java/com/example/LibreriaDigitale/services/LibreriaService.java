package com.example.LibreriaDigitale.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        libro.setNumeroLettura(0);
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        libro.setDataAggiuntaLibreria(sqlDate);
        utente.aggiungiLibro(libro);
        utenteRepository.save(utente);
    }

    public Set<Libro> vediLibriPerUtente(Integer idUtente) {
        Utente utente = utenteRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        return utente.getLibri();
    }

    public void rimuoviLibroPerUtente(Integer idUtente, Integer idLibro) {
        Utente utente = utenteRepository.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Libro libro = libroRepo.findById(idLibro).orElseThrow(() -> new RuntimeException("libro non trovato"));

        if (!utente.getLibri().contains(libro)) {
            throw new IllegalArgumentException("l'utente non ha quel libro");
        }

        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);

        libro.setDataEliminazione(sqlDate);
        utente.getLibri().remove(libro);
        utenteRepository.save(utente);
    }

    public void modificaLibro(Integer idLibro, Libro libroAggiornato) {
        Libro libro = libroRepo.findById(idLibro).orElseThrow(() -> new RuntimeException("libro non trovato"));

        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);

        libro.setAutore(libroAggiornato.getAutore());
        libro.setCodiceISBN(libroAggiornato.getCodiceISBN());
        libro.setTitolo(libroAggiornato.getTitolo());
        libro.setTrama(libroAggiornato.getTrama());
        libro.setNumeroLettura(0);
        libro.setDataAggiuntaLibreria(sqlDate);

        libroRepo.save(libro);
    }

    public void incrementaNumeroLetture(Integer idLibro) {
        Libro libro = libroRepo.findById(idLibro).orElseThrow(() -> new RuntimeException("libro non trovato"));

        libro.setNumeroLettura(libro.getNumeroLettura() + 1);
        libroRepo.save(libro);
    }

    public Libro getLibroById(Integer idLibro) {
        return libroRepo.findById(idLibro).orElseThrow(() -> new RuntimeException("libro non trovato"));
    }

}
