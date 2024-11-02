package com.gianlucacerreta.com.viaggiaziendali.repositories;

import com.gianlucacerreta.com.viaggiaziendali.entities.Dipendente;
import com.gianlucacerreta.com.viaggiaziendali.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}