package com.gianlucacerreta.com.viaggiaziendali.services;

import com.gianlucacerreta.com.viaggiaziendali.entities.Prenotazione;
import com.gianlucacerreta.com.viaggiaziendali.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        boolean esiste = prenotazioneRepository.existsByDipendenteAndDataRichiesta(
                prenotazione.getDipendente(), prenotazione.getDataRichiesta());
        if (esiste) {
            throw new RuntimeException("Il dipendente ha già una prenotazione per questa data!");
        }
        return prenotazioneRepository.save(prenotazione);
    }
}
