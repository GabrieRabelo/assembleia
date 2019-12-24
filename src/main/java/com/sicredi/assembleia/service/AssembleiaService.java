package com.sicredi.assembleia.service;

import com.sicredi.assembleia.models.Assembleia;
import com.sicredi.assembleia.repository.assembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssembleiaService {

    @Autowired
    private assembleiaRepository AssembleiaRepository;

    public static Assembleia registrarAssembleia(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }
}
