package com.sicredi.assembleia.service;

import com.sicredi.assembleia.models.Assembleia;
import com.sicredi.assembleia.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssembleiaService {

    @Autowired
    private AssembleiaRepository assembleiaRepository;

    public Assembleia registrarAssembleia(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }

    public Iterable<Assembleia> findAll() {
        return assembleiaRepository.findAll();
    }

    public Optional<Assembleia> findById(Long id) {
        return assembleiaRepository.findById(id);
    }
}
