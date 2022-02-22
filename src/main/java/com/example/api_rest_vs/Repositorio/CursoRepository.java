package com.example.api_rest_vs.Repositorio;

import com.example.api_rest_vs.Modelo.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public  interface CursoRepository  extends JpaRepository<Curso, Integer>{
    
}
