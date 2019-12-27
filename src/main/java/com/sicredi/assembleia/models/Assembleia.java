package com.sicredi.assembleia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assembleia")
public class Assembleia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "assembleia_id")
    private List<Pauta> pautas = new ArrayList<>();

    public Assembleia() {}

    public List<Pauta> getPautas() { return pautas; }

    public Long getId() { return this.id; }
}
