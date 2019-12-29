package com.sicredi.assembleia.service;

import com.sicredi.assembleia.models.Associado;
import com.sicredi.assembleia.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public Associado registrarAssociado(Associado associado) {
        return associadoRepository.save(associado);
    }

    public Iterable<Associado> findAll() {
        return associadoRepository.findAll();
    }

    public Optional<Associado> findById(Long id) {
        return associadoRepository.findById(id);
    }
}
