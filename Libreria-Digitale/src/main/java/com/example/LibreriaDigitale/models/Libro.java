package com.example.LibreriaDigitale.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_libro;

    private String titolo;

    private String autore;

    @Column(name = "codice_iBSN")
    private String codiceISBN;

    @Column(name = "data_aggiuntaLibreria")
    private Date dataAggiuntaLibreria;

    @Column(name = "data_eliminazione")
    private Date dataEliminazione;

    private String trama;

    @Column(name = "numero_letture")
    private int numeroLettura;

    @ManyToMany(mappedBy = "libri", fetch = FetchType.EAGER)
    private Set<Utente> utenti;

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public Date getDataAggiuntaLibreria() {
        return dataAggiuntaLibreria;
    }

    public void setDataAggiuntaLibreria(Date dataAggiuntaLibreria) {
        this.dataAggiuntaLibreria = dataAggiuntaLibreria;
    }

    public Date getDataEliminazione() {
        return dataEliminazione;
    }

    public void setDataEliminazione(Date dataEliminazione) {
        this.dataEliminazione = dataEliminazione;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public int getNumeroLettura() {
        return numeroLettura;
    }

    public void setNumeroLettura(int numeroLettura) {
        this.numeroLettura = numeroLettura;
    }

}
