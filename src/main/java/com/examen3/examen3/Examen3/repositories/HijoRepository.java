package com.examen3.examen3.Examen3.repositories;

import com.examen3.examen3.Examen3.domain.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HijoRepository extends JpaRepository<Hijo, Long> {
}
