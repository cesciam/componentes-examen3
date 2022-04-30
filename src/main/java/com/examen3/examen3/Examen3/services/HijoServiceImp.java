package com.examen3.examen3.Examen3.services;

import com.examen3.examen3.Examen3.domain.Encargado;
import com.examen3.examen3.Examen3.domain.Hijo;
import com.examen3.examen3.Examen3.repositories.EncargadoRepository;
import com.examen3.examen3.Examen3.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HijoServiceImp implements HijoService{
    @Autowired
    HijoRepository hijoRepository;

    @Autowired
    EncargadoService encargadoService;

    @Override
    public List<Hijo> getAll() {
        return hijoRepository.findAll();
    }

    @Override
    public Optional<Hijo> findById(long id) {
        return hijoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Hijo> save(Hijo hijo) {
        Optional<Encargado> encargado = encargadoService.findById(hijo.getIdEncargado());
        if(encargado.isPresent()){
            hijo.setEncargado(encargado.get());
        }else{
            return Optional.of(hijo);
        }

        return Optional.of(hijoRepository.save(hijo));
    }

    @Override
    public Optional<Hijo> update(Hijo hijo) {
        Optional<Hijo> record = hijoRepository.findById(hijo.getId());
        if (record.isPresent()) {
            Hijo data = record.get();
            data.setNombre(hijo.getNombre());
            data.setAlergias(hijo.getAlergias());
            data.setEncargado(data.getEncargado());
            data.setGuarderia(hijo.isGuarderia());
            data.setLectura(hijo.isLectura());
            return Optional.of(hijoRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Hijo> result = hijoRepository.findById(id);
        if (result.isPresent()){
            hijoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
