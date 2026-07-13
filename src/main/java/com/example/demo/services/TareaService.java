package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Tarea;
import com.example.demo.repositories.TareaRepository;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    
    public List<Tarea> obtenerTareasPorUsuario (Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

    public Tarea crearTarea(Tarea nuevaTarea) {
        return tareaRepository.save(nuevaTarea);
    }
}
