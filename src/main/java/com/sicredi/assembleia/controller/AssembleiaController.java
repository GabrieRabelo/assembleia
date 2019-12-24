package com.sicredi.assembleia.controller;

import com.sicredi.assembleia.models.Assembleia;
import com.sicredi.assembleia.service.AssembleiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assembleia")
public class AssembleiaController {

    @Autowired
    private AssembleiaService assembleiaService;

    public AssembleiaController(AssembleiaService assembleiaMainService){
        this.assembleiaService = assembleiaMainService;
    }

    @PostMapping("/registrar")
    public Assembleia registrarAssembleia() {
        Assembleia assembleia = new Assembleia();
        return assembleiaService.registrarAssembleia(assembleia);
    }

}
