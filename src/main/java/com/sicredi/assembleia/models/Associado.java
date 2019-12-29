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
    @JoinColumn(name = "associado_id")
    private Long associado_id;

    @JsonCreator
    public Associado() { }

    public Associado(
            @JsonProperty("cpf") String cpf,
            @JsonProperty("voto") String voto
    ) {
        this.cpf = cpf;
        this.voto = voto;
    }

    public String getCpf() { return this.cpf; }

    public String getVoto() { return this.voto; }

    public Long getAssociado_id() { return this.associado_id; }
}