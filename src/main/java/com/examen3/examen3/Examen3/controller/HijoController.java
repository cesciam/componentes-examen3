package com.examen3.examen3.Examen3.controller;

import com.examen3.examen3.Examen3.domain.Hijo;
import com.examen3.examen3.Examen3.services.HijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/hijo"})
public class HijoController {
    @Autowired
    private HijoService hijoService;

    @GetMapping
    public List getAll(){
        return hijoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Hijo> findById(@PathVariable long id){
        Optional<Hijo> result = hijoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hijo> create(@RequestBody Hijo hijo){
        Optional<Hijo> optionalHijo =  hijoService.save(hijo);
        if (optionalHijo.get().isNull()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(optionalHijo.get());
        }

    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") long id, @RequestBody Hijo hijo){
        hijo.setId(id);
        Optional<Hijo> result = hijoService.update(hijo);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
