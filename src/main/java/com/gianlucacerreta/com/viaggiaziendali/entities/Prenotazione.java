package com.gianlucacerreta.com.viaggiaziendali.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    @Column(nullable = false)
    private LocalDate dataRichiesta;

    private String note;

    public Prenotazione() {
    }

    public Prenotazione(Long id, Dipendente dipendente, Viaggio viaggio, LocalDate dataRichiesta, String note) {
        this.id = id;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.dataRichiesta = dataRichiesta;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

