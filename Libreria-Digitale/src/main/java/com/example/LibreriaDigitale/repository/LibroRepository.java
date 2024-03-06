package com.example.LibreriaDigitale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibreriaDigitale.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
