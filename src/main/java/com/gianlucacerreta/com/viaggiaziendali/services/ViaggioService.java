package com.gianlucacerreta.com.viaggiaziendali.services;

import com.gianlucacerreta.com.viaggiaziendali.entities.Viaggio;
import com.gianlucacerreta.com.viaggiaziendali.enums.StatoViaggio;
import com.gianlucacerreta.com.viaggiaziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio aggiornaStatoViaggio(Long id, StatoViaggio nuovoStato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato!"));
        viaggio.setStato(nuovoStato);
        return viaggioRepository.save(viaggio);
    }

}
