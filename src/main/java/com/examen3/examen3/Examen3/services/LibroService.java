package com.examen3.examen3.Examen3.services;

import com.examen3.examen3.Examen3.domain.Libro;
import com.examen3.examen3.Examen3.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    public List<Libro> getAllLibros(int count) {
        return this.libroRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Libro> getLibro(int id) {
        return this.libroRepository.findById(id);
    }

    public Libro createLibro(String nombre) {
        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setActivo(true);
        return this.libroRepository.save(libro);
    }

    public void save(Libro libroEntity) {
        this.libroRepository.save(libroEntity);
    }
}
