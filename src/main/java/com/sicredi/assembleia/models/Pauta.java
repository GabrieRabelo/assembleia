package com.sicredi.assembleia.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    @JoinColumn(name = "assembleia_id")
    private Long assembleia_id;

    @OneToMany
    @JoinColumn(name = "associado_id")
    private List<Associado> associados = new ArrayList<>();

    @JsonCreator
    public Pauta() { }

    @JsonCreator
    public Pauta(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("assembleia") Long assembleia_id
            ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.assembleia_id = assembleia_id;
    }

    public Long getId() { return this.id; }

    public String getTitulo() { return this.titulo; }

    public String getDescricao() { return this.descricao; }

    public Long getAssembleiaId() { return this.assembleia_id; }

    public List<Associado> getAssociados() { return this.associados; }
}
