package com.api.crud1.tareas.repository;

import com.api.crud1.tareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITareaRepository extends JpaRepository<Tarea, Long> {
}