package com.gianlucacerreta.com.viaggiaziendali.entities;

import com.gianlucacerreta.com.viaggiaziendali.enums.StatoViaggio;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinazione;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoViaggio stato;

    public Viaggio() {
    }

    public Viaggio(Long id, String destinazione, LocalDate data, StatoViaggio stato) {
        this.id = id;
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatoViaggio getStato() {
        return stato;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }
}
