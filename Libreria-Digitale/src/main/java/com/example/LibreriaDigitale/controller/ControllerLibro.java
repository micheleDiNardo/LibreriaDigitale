package com.example.LibreriaDigitale.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibreriaDigitale.login.TokenManager;
import com.example.LibreriaDigitale.models.Libro;
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

        try {

            libroService.aggiungiLibroPerUtente(idUtente, idLibro);
            return ResponseEntity.ok("libro aggiunto all'utente con id: " + idUtente);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERRORE NELLA AGGIUNTA DI LIBRO ALL'UTENTE SPECIFICO");
        }
    }

    @GetMapping("/libri/utente")
    public ResponseEntity<Object> vediLibriPerUtente(
            @RequestParam("idUtente") Integer idUtente,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        try {

            Set<Libro> libriUtente = libroService.vediLibriPerUtente(idUtente);
            return ResponseEntity.ok(libriUtente);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRORE NELLA RIMOZIONE DEL LIBRO");
        }
    }

    @DeleteMapping("/rimuoviLibro")
    public ResponseEntity<String> eliminaLibri(
            @RequestParam("idUtente") Integer idUtente,
            @RequestParam("idLibro") Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        try {

            libroService.rimuoviLibroPerUtente(idUtente, idLibro);
            return ResponseEntity.ok("libro con id : " + idLibro + "rimosso all'utente con id: " + idUtente);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRORE NELLA RIMOZIONE DEL LIBRO");
        }
    }

    @PutMapping("modifica")
    public ResponseEntity<String> modifcaLibro(
            @RequestParam("idLibro") Integer idLibro,
            @RequestBody Libro libroAggiornato,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        try {

            libroService.modificaLibro(idLibro, libroAggiornato);
            return ResponseEntity.ok("modificato correttamente il libro con id : " + idLibro);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRORE NELLA MODIFICA DEL LIBRO");
        }
    }

    @PutMapping("lettura/{idLibro}")
    public ResponseEntity<String> aumentaNumeroLetture(
            @PathVariable Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        try {

            libroService.incrementaNumeroLetture(idLibro);
            return ResponseEntity.ok("il numero di letture è stato incrementato");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERRORE NELL'INCREMENTO NUMERO LETTURE");
        }
    }

    @GetMapping("libro/{idLibro}")
    public ResponseEntity<Libro> vediLibroPerId(
            @PathVariable Integer idLibro,
            @RequestHeader("Authorization") String token) {

        if (!TokenManager.validatoreToken(token)) {
            throw new IllegalArgumentException("Token non valido");
        }

        try {

            Libro listaLibroPerId = libroService.getLibroById(idLibro);
            return ResponseEntity.ok(listaLibroPerId);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
