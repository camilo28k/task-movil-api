package com.api.crud1.usuarios.service;

import com.api.crud1.usuarios.model.Usuario;
import com.api.crud1.usuarios.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setPassword(usuarioActualizado.getPassword());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
