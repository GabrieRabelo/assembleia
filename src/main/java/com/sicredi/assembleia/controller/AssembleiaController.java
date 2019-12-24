package com.sicredi.assembleia.controller;

import com.sicredi.assembleia.exceptions.ErrorResponse;
import com.sicredi.assembleia.models.Assembleia;
import com.sicredi.assembleia.service.AssembleiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assembleia")
public class AssembleiaController {

    @Autowired
    private AssembleiaService assembleiaService;

    public AssembleiaController(AssembleiaService assembleiaService){
        this.assembleiaService = assembleiaService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(assembleiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Assembleia> assembleia = assembleiaService.findById(id);
        if (assembleia.isPresent()) {
            return ResponseEntity.ok(assembleia.get());
        }
        else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse(HttpStatus.NOT_FOUND, "Assembleia com este id não existe no nosso banco."));
        }
    }

    @PostMapping("/registrar")
    public Assembleia registrarAssembleia() {
        Assembleia assembleia = new Assembleia();
        return assembleiaService.registrarAssembleia(assembleia);
    }

}
