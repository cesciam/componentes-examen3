package com.examen3.examen3.Examen3.controller;

import com.examen3.examen3.Examen3.domain.Encargado;
import com.examen3.examen3.Examen3.services.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/encargado"})
public class EncargadoFamController {
    @Autowired
    private EncargadoService encargadoService;

    @GetMapping
    public List getAll(){
        return encargadoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Encargado> findById(@PathVariable long id){
        Optional<Encargado> result = encargadoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Encargado create(@RequestBody Encargado encargado){
        return encargadoService.save(encargado).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Encargado> update(@PathVariable("id") long id, @RequestBody Encargado contact){
        contact.setId(id);
        Optional<Encargado> result = encargadoService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (encargadoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
