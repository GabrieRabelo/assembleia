package com.sicredi.assembleia.service;

import com.sicredi.assembleia.models.Pauta;
import com.sicredi.assembleia.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public Pauta registrarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public Iterable<Pauta> findAll() {
        return pautaRepository.findAll();
    }

    public Optional<Pauta> findById(Long id) {
        return pautaRepository.findById(id);
    }
}
