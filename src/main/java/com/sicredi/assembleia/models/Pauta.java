package com.sicredi.assembleia.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

    private Date dtAbertura, dtFechamento;

    @NotNull
    @JoinColumn(name = "assembleia_id")
    private Long assembleia_id;

    @OneToMany
    @JoinColumn(name = "pauta_id")
    private List<Associado> associados = new ArrayList<>();

    @JsonCreator
    public Pauta() { }

    @JsonCreator
    public Pauta(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("assembleia") Long assembleia_id,
            @JsonProperty("dtFechamentoMinutos") Long dtFechamentoMinutos
            ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.assembleia_id = assembleia_id;
        this.dtAbertura = Date.from(Instant.now());
        if(dtFechamentoMinutos > 0) {
            this.dtFechamento = new Date(System.currentTimeMillis()+dtFechamentoMinutos*60*1000);
        } else {
            this.dtFechamento = new Date(System.currentTimeMillis()+60*1000);
        }

    }

    public Long getId() { return this.id; }

    public String getTitulo() { return this.titulo; }

    public String getDescricao() { return this.descricao; }

    public Long getAssembleiaId() { return this.assembleia_id; }

    public List<Associado> getAssociados() { return this.associados; }

    public Date getDtAbertura() { return this.dtAbertura; }

    public Date getDtFechamento() { return this.dtFechamento; }
}
