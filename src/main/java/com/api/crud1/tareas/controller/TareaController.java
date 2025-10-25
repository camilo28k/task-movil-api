package com.api.crud1.tareas.controller;

import com.api.crud1.tareas.model.Tarea;
import com.api.crud1.tareas.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Tarea> obtenerPorId(@PathVariable Long id) {
        return tareaService.obtenerPorId(id);
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}

