package com.gianlucacerreta.com.viaggiaziendali.controllers;

import com.gianlucacerreta.com.viaggiaziendali.entities.Viaggio;
import com.gianlucacerreta.com.viaggiaziendali.exceptions.ResourceNotFoundException;
import com.gianlucacerreta.com.viaggiaziendali.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    public ResponseEntity<Viaggio> creaViaggio(@RequestBody Viaggio viaggio) {
        Viaggio nuovoViaggio = viaggioService.creaViaggio(viaggio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoViaggio);
    }

    @GetMapping
    public ResponseEntity<List<Viaggio>> getAllViaggi() {
        List<Viaggio> viaggi = viaggioService.getAllViaggi();
        return ResponseEntity.ok(viaggi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        Viaggio viaggio = viaggioService.getViaggioById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Viaggio non trovato con id " + id));
        return ResponseEntity.ok(viaggio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> aggiornaViaggio(@PathVariable Long id, @RequestBody Viaggio dettagliViaggio) {
        Viaggio viaggioAggiornato = viaggioService.aggiornaViaggio(id, dettagliViaggio);
        return ResponseEntity.ok(viaggioAggiornato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminaViaggio(@PathVariable Long id) {
        viaggioService.eliminaViaggio(id);
        return ResponseEntity.ok("Viaggio eliminato con successo.");
    }
}

