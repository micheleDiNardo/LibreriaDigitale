package com.example.LibreriaDigitale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibreriaDigitale.models.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    Utente findByEmail(String email);
}
