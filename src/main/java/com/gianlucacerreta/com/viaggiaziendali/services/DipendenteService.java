package com.gianlucacerreta.com.viaggiaziendali.services;

import com.gianlucacerreta.com.viaggiaziendali.entities.Dipendente;
import com.gianlucacerreta.com.viaggiaziendali.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente salvaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

}

