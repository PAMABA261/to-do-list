package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Tarea;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.TareaRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public TareaService(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Tarea> obtenerTareasPorUsuario (Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

    public Tarea crearTarea (Long usuarioId, Tarea nuevaTarea) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + usuarioId));
        nuevaTarea.setUsuario(usuario);
        return tareaRepository.save(nuevaTarea);
    }

    public Tarea actualizarTarea (Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID " + id));
        tarea.setIs_completed(true);
        return tareaRepository.save(tarea);
    }

    public void borrarTarea (Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID " + id));
        tareaRepository.delete(tarea);
    }
}
