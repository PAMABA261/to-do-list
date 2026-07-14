package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Tarea;
import com.example.demo.services.TareaService;


@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public Tarea crearTarea (@RequestBody Tarea nuevaTarea) {
        return tareaService.crearTarea(nuevaTarea);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Tarea> obtenerTareas (@PathVariable Long usuarioId) {
        return tareaService.obtenerTareasPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea (@PathVariable Long id) {
        return tareaService.actualizarTarea(id);
    }

    @DeleteMapping("/{id}")
    public void borrarTarea (@PathVariable Long id) {
        tareaService.borrarTarea(id);
    }
}
