package com.sicredi.assembleia.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "assembleia_id")
    private Assembleia assembleia;

    @OneToMany
    @JoinColumn(name = "associados")
    private List<Associado> associados = new ArrayList<>();

    @JsonCreator
    public Pauta() { }

    @JsonCreator
    public Pauta(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("descricao") String descricao,
            @JsonProperty("assembleia") Assembleia assembleia
            ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.assembleia = assembleia;
    }

    public String getTitulo() { return this.titulo; }

    public String getDescricao() { return this.descricao; }

    public Assembleia getAssembleia() { return this.assembleia; }

    public List<Associado> getAssociados() { return this.associados; }

    public void setAssociados(Associado associado) { this.associados.add(associado); }
}
