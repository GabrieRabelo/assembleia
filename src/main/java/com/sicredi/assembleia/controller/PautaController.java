package com.sicredi.assembleia.controller;

import com.sicredi.assembleia.exceptions.ErrorResponse;
import com.sicredi.assembleia.models.Pauta;
import com.sicredi.assembleia.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "Pauta")
@RequestMapping("/api/v1/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    public PautaController(PautaService pautaService) { this.pautaService = pautaService; }

    @ApiOperation(value = "Encontra todas pautas")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(pautaService.findAll());
    }

    @ApiOperation(value = "Encontra pautas por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Pauta> pauta = pautaService.findById(id);
        if (pauta.isPresent()) {
            return ResponseEntity.ok(pauta.get());
        }
        else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse(HttpStatus.NOT_FOUND, "Pauta com este id não existe no nosso banco."));
        }
    }

    @ApiOperation(value = "Registra uma pauta")
    @PostMapping("/registrar")
    public Pauta registrarPauta(@RequestBody Pauta pauta) {
        return pautaService.registrarPauta(pauta);
    }
}
