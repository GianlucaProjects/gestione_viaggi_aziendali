package com.gianlucacerreta.com.viaggiaziendali.controllers;

import com.gianlucacerreta.com.viaggiaziendali.entities.Prenotazione;
import com.gianlucacerreta.com.viaggiaziendali.repositories.DipendenteRepository;
import com.gianlucacerreta.com.viaggiaziendali.repositories.PrenotazioneRepository;
import com.gianlucacerreta.com.viaggiaziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @PostMapping
    public ResponseEntity<?> creaPrenotazione(@RequestBody Prenotazione prenotazione) {
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository
                .findByDipendenteIdAndDataRichiesta(prenotazione.getDipendente().getId(), prenotazione.getDataRichiesta());
        if (prenotazioneEsistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Il dipendente ha già una prenotazione per questa data.");
        }

        Prenotazione nuovaPrenotazione = prenotazioneRepository.save(prenotazione);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovaPrenotazione);
    }

    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        return ResponseEntity.ok(prenotazioni);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        if (prenotazione.isPresent()) {
            return ResponseEntity.ok(prenotazione.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prenotazione non trovata!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> aggiornaPrenotazione(@PathVariable Long id, @RequestBody Prenotazione dettagliPrenotazione) {
        Optional<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findById(id);
        if (prenotazioneEsistente.isPresent()) {
            Prenotazione prenotazione = prenotazioneEsistente.get();
            prenotazione.setDataRichiesta(dettagliPrenotazione.getDataRichiesta());
            prenotazione.setNote(dettagliPrenotazione.getNote());
            Prenotazione prenotazioneAggiornata = prenotazioneRepository.save(prenotazione);
            return ResponseEntity.ok(prenotazioneAggiornata);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prenotazione non trovata!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminaPrenotazione(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        if (prenotazione.isPresent()) {
            prenotazioneRepository.delete(prenotazione.get());
            return ResponseEntity.ok("Prenotazione eliminata con successo!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prenotazione non trovata!");
        }
    }










}


