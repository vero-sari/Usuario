package com.example.api_rest_vs.Controlador;

import java.util.List;
import java.util.stream.Collectors;

import com.example.api_rest_vs.Modelo.Curso;
import com.example.api_rest_vs.Repositorio.CursoRepository;
import com.example.api_rest_vs.Service.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
   
    @Autowired
    private CursoRepository cursoRepository;
@Autowired
private S3Service s3Service;
    @GetMapping
    List<Curso>getAll(){
        return cursoRepository.findAll()
        .stream()
        		.peek(curso-> curso.setImagenUrl(s3Service.getObjectUrl(curso.getImagenPath())))
        		.collect(Collectors.toList());
    }

    @PostMapping
    Curso create(@RequestBody Curso curso){
      curso.setImagenUrl(s3Service.getObjectUrl(curso.getImagenPath()));
      return cursoRepository.save(curso);  
    }
}
