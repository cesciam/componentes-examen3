package com.examen3.examen3.Examen3.controller;

import com.examen3.examen3.Examen3.domain.Encargado;
import com.examen3.examen3.Examen3.domain.Hijo;
import com.examen3.examen3.Examen3.domain.Libro;
import com.examen3.examen3.Examen3.services.HijoService;
import com.examen3.examen3.Examen3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/lectura"})
public class LecturasController {
    @Autowired
    private HijoService hijoService;

    @Autowired
    private LibroService libroService;

    @PutMapping(value="/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") int id, @RequestParam(name="id_hijo") long id_hijo){
        Optional<Hijo> result_hijo = hijoService.findById(id_hijo);
        Optional<Libro> result_libro = libroService.getLibro(id);
        if (result_hijo.isPresent() && result_libro.isPresent()){
            Hijo hijo = result_hijo.get();
            hijo.getLibrosLeidos().add(result_libro.get());
            hijoService.update(hijo);
            return ResponseEntity.ok().body(result_hijo.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<List> findById(@PathVariable long id){
        Optional<Hijo> result = hijoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get().getLibrosLeidos());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/all"})
    public List findAll(){
        List<Hijo> hijoList = hijoService.getAll();
        List<String> response = new ArrayList<>();
        for (Hijo hijo: hijoList) {
            response.add(hijo.getNombre() + " " + hijo.getLibrosLeidos().size());
        }
        return response;
    }
}
