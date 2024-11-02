package com.gianlucacerreta.com.viaggiaziendali.controllers;

import com.gianlucacerreta.com.viaggiaziendali.entities.Viaggio;
import com.gianlucacerreta.com.viaggiaziendali.enums.StatoViaggio;
import com.gianlucacerreta.com.viaggiaziendali.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    @PutMapping("/{id}/stato")
    public ResponseEntity<Viaggio> aggiornaStatoViaggio(
            @PathVariable Long id,
            @RequestParam StatoViaggio stato) {
        Viaggio viaggioAggiornato = viaggioService.aggiornaStatoViaggio(id, stato);
        return ResponseEntity.ok(viaggioAggiornato);
    }
}

