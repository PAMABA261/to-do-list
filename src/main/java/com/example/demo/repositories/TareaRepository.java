package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    public List<Tarea>findByUsuarioId(Long usuarioId);
    
}
