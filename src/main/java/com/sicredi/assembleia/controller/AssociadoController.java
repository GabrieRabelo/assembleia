package com.sicredi.assembleia.controller;

import com.sicredi.assembleia.exceptions.ErrorResponse;
import com.sicredi.assembleia.models.Associado;
import com.sicredi.assembleia.service.AssociadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "Associado")
@RequestMapping("/api/v1/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    public AssociadoController(AssociadoService associadoService) { this.associadoService = associadoService; }

    @ApiOperation(value = "Encontra todos votos")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(associadoService.findAll());
    }

    @ApiOperation(value = "Encontra votos por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Associado> associado = associadoService.findById(id);
        if (associado.isPresent()) {
            return ResponseEntity.ok(associado.get());
        }
        else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse(HttpStatus.NOT_FOUND, "O voto com este id não foi encontrado em nosso banco."));
        }
    }

    @ApiOperation(value = "Registra um associado na pauta")
    @PostMapping("/registrar")
    public Associado registrarAssociado(@RequestBody Associado associado) {
        return associadoService.registrarAssociado(associado);
    }
}
