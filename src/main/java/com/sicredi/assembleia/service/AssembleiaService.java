package com.sicredi.assembleia.service;

import com.sicredi.assembleia.models.Assembleia;
import com.sicredi.assembleia.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssembleiaService {

    @Autowired
    private AssembleiaRepository assembleiaRepository;

    public Assembleia registrarAssembleia(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }
}
