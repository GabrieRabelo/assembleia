package com.sicredi.assembleia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Associado> Associados = new ArrayList<>();
}
