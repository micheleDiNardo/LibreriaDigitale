package com.example.LibreriaDigitale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibreriaDigitale.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
