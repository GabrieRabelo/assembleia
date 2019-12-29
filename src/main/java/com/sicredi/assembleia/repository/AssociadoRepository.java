package com.sicredi.assembleia.repository;

import com.sicredi.assembleia.models.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}