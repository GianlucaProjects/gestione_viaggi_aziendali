package com.gianlucacerreta.com.viaggiaziendali.services;

import com.gianlucacerreta.com.viaggiaziendali.entities.Viaggio;
import com.gianlucacerreta.com.viaggiaziendali.enums.StatoViaggio;
import com.gianlucacerreta.com.viaggiaziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio creaViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Optional<Viaggio> getViaggioById(Long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio aggiornaViaggio(Long id, Viaggio dettagliViaggio) {
        return viaggioRepository.findById(id).map(viaggio -> {
            viaggio.setDestinazione(dettagliViaggio.getDestinazione());
            viaggio.setData(dettagliViaggio.getData());
            viaggio.setStato(dettagliViaggio.getStato());
            // Aggiorna altre proprietà se necessario
            return viaggioRepository.save(viaggio);
        }).orElseThrow(() -> new RuntimeException("Viaggio non trovato con id " + id));
    }

    public void eliminaViaggio(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato con id " + id));
        viaggioRepository.delete(viaggio);
    }
}
