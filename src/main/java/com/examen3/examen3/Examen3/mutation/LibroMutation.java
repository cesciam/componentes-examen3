package com.examen3.examen3.Examen3.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.examen3.examen3.Examen3.domain.Libro;
import com.examen3.examen3.Examen3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {
    @Autowired
    private LibroService libroService;
    public Libro createLibro(String nombre) {
        return this.libroService.createLibro(nombre);
    }

    public Libro updateLibro(int id, String nombre) {
        Optional<Libro> libro = this.libroService.getLibro(id);
        if (libro.isPresent()) {
            Libro libroEntity = libro.get();
            if (nombre!=null)
                libroEntity.setNombre(nombre);
            libroService.save(libroEntity);
            return libroEntity;
        }
        return null;
    }

    public Libro updateEstado(int id, boolean estado) {
        Optional<Libro> libro = this.libroService.getLibro(id);
        if (libro.isPresent()) {
            Libro libroEntity = libro.get();
            libroEntity.setActivo(estado);
            libroService.save(libroEntity);
            return libroEntity;
        }
        return null;
    }
}
