package com.sicredi.assembleia.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="associado")
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cpf;

    @NotNull
    private String voto;

    @NotNull
    @JoinColumn(name = "pauta_id")
    private Long pauta_id;

    @JsonCreator
    public Associado() { }

    public Associado(
            @JsonProperty("cpf") String cpf,
            @JsonProperty("voto") String voto,
            @JsonProperty("pauta") Long pauta_id
    ) {
        this.cpf = cpf;
        this.voto = voto;
        this.pauta_id = pauta_id;
    }

    public String getCpf() { return this.cpf; }

    public String getVoto() { return this.voto; }

    public Long getPauta_id() { return this.pauta_id; }
}