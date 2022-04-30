package com.examen3.examen3.Examen3.services;

import com.examen3.examen3.Examen3.domain.Encargado;
import com.examen3.examen3.Examen3.repositories.EncargadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncargadoServiceImp implements EncargadoService {
    @Autowired
    EncargadoRepository encargadoRepository;
    @Override
    public List<Encargado> getAll() {
        return encargadoRepository.findAll();
    }

    @Override
    public Optional<Encargado> findById(long id) {
        return encargadoRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Encargado> save(Encargado encargado) {
        return Optional.of(encargadoRepository.save(encargado));
    }

    @Override
    public Optional<Encargado> update(Encargado encargado) {
        Optional<Encargado> record = encargadoRepository.findById(encargado.getId());
        if (record.isPresent()) {
            Encargado data = record.get();
            data.setNombre(encargado.getNombre());
            data.setCedula(encargado.getCedula());
            data.setDireccion(encargado.getDireccion());
            data.setTelefonoUno(encargado.getTelefonoUno());
            data.setTelefonoDos(encargado.getTelefonoDos());
            return Optional.of(encargadoRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
