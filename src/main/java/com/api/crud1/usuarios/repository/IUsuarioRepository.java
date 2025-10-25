package com.api.crud1.usuarios.repository;

import com.api.crud1.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
