package com.sicredi.assembleia.models;

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
    @JoinColumn(name = "pauta_id")
    private List<Pauta> pautas = new ArrayList<>();

    public Assembleia () {}

    public List<Pauta> getPautas() { return pautas; }

    public void setPautas(Pauta pauta) { this.pautas.add(pauta); }

    public Long getId() { return this.id; }
}
