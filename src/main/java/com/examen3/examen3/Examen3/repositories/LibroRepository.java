package com.examen3.examen3.Examen3.repositories;

import com.examen3.examen3.Examen3.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
