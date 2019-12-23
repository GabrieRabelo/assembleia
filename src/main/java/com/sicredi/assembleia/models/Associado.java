package com.sicredi.assembleia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name="associado")
    public class Associado implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "cpf")
        @NotNull
        private String cpf;

        @Column(name = "voto")
        @NotNull
        private boolean voto;
    }