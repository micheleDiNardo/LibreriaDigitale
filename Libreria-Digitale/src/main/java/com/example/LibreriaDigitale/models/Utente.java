package com.example.LibreriaDigitale.models;

import java.util.List;
import java.util.Set;

import jakarta.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_utente;

    @NotBlank
    private String name;

    @NotBlank
    private String cognome;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ManyToMany
    @JoinTable(name = "utente_libro", joinColumns = {
            @JoinColumn(name = "utente_idFK")
    }, inverseJoinColumns = @JoinColumn(name = "libro_idFK"))
    private Set<Libro> libri;

    public Set<Libro> getLibri() {
        return libri;
    }

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

}
