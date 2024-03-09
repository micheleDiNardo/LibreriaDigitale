package com.example.LibreriaDigitale.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibreriaDigitale.models.Libro;
import com.example.LibreriaDigitale.models.Utente;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
