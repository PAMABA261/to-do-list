package com.example.demo.services;

import java.util.List;
import java.util.Optional;

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

    public Tarea crearTarea (Tarea nuevaTarea) {
        return tareaRepository.save(nuevaTarea);
    }

    public Tarea actualizarTarea (Long id) {
        Optional <Tarea> aux = tareaRepository.findById(id);
        if (aux.isPresent()) {
            Tarea tareaParaModificar = aux.get();
            tareaParaModificar.setIs_completed(true);
            return tareaRepository.save(tareaParaModificar);
        }
        return null;

    }

    public void borrarTarea (Long id) {
        Optional <Tarea> aux = tareaRepository.findById(id);
        if (aux.isPresent()) {
            tareaRepository.deleteById(id);
        }
    }
}
