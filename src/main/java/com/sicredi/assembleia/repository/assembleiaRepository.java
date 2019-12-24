package com.sicredi.assembleia.repository;

import com.sicredi.assembleia.models.Assembleia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface assembleiaRepository extends JpaRepository<Assembleia, Long> {
}
