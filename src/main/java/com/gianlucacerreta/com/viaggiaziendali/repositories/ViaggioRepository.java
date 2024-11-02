package com.gianlucacerreta.com.viaggiaziendali.repositories;

import com.gianlucacerreta.com.viaggiaziendali.entities.Viaggio;
import com.gianlucacerreta.com.viaggiaziendali.enums.StatoViaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    List<Viaggio> findByStato(StatoViaggio stato);
}