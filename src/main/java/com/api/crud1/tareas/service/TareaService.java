package com.api.crud1.tareas.service;

import com.api.crud1.tareas.model.Tarea;
import com.api.crud1.tareas.repository.ITareaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final ITareaRepository tareaRepository;

    public TareaService(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setCompletada(tareaActualizada.isCompletada());
            tarea.setUsuarioId(tareaActualizada.getUsuarioId());
            return tareaRepository.save(tarea);
        }).orElse(null);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
