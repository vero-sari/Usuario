package com.example.api_rest_vs.Repositorio;

import java.util.List;

import com.example.api_rest_vs.Modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Rusuario extends JpaRepository<Usuario,Long>{
    Usuario findAllById(Long id);  
}
