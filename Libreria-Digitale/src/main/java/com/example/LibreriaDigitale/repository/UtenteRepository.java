package com.example.LibreriaDigitale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibreriaDigitale.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
