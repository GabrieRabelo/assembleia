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

    @Column(name = "cpf")
    @NotNull
    private String cpf;

    @Column(name = "voto")
    @NotNull
    private String voto;

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
}