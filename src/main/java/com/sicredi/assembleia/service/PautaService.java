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

    public long negativeCounter(Long pautaId) {
        if(findById(pautaId).isPresent()){
            return findById(pautaId).get().getAssociados()
                    .stream()
                    .filter(p -> p.getVoto().equalsIgnoreCase("sim"))
                    .count();
        }
        return 0;
    }

    public long positiveCounter(Long pautaId) {
        if(findById(pautaId).isPresent()){
            return findById(pautaId).get().getAssociados()
                    .stream()
                    .filter(p -> p.getVoto().equalsIgnoreCase("nao"))
                    .count();
        }
        return 0;
    }

}
