package com.example.api_rest_vs.Controlador;


import java.util.ArrayList;
import java.util.List;

import com.example.api_rest_vs.Modelo.RespuestaGenerica;
import com.example.api_rest_vs.Modelo.Usuario;
import com.example.api_rest_vs.Repositorio.Rusuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cusuario {
    
 @Autowired
 private Rusuario rusuario; 


 @GetMapping("/list-usuario")
 public ResponseEntity<RespuestaGenerica> getUsuario(){
     List<Usuario> lista = rusuario.findAll();
     RespuestaGenerica<Usuario> respuesta = new RespuestaGenerica<>("Listado generado exitosamente",lista,0);
     return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
     
 }

 @PostMapping("/usuario")
 public ResponseEntity<RespuestaGenerica> crearUsuario(@RequestBody Usuario usuario){
     
     List<Usuario> data = new ArrayList<Usuario>();
     RespuestaGenerica<Usuario> respuesta = new RespuestaGenerica<>();
     try{           
         Usuario usuarioInsert = rusuario.save(usuario);
         if(usuarioInsert!=null){
             data.add(usuarioInsert);
             respuesta.setMensaje("Usuario ingresada exitosamente");
             respuesta.setData(data);
             respuesta.setEstado(0);
         }  
     }
     catch(Exception ex){
         respuesta.setMensaje("Hubo un problema al insertar el usuario");
         respuesta.setData(data);
         respuesta.setEstado(1);
         System.out.println("No se pudo almacenar el objeto en la base de datos");
         
     }
     return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);   
/*public ResponseEntity<?> create(@RequestBody Usuario usuario){
return ResponseEntity.status(HttpStatus.CREATED).body(Usuario.save(usuario) );*/
 }
 
 


 @PutMapping("/usuario/{id}")
 public Usuario actualizarUsuario(@RequestBody Usuario newUsuario,@PathVariable Long id){

     try{
         return rusuario.findById(id)
         .map(usuario ->{
             usuario.setName(newUsuario.getName());
             return rusuario.save(usuario);
         })
         .orElseGet(
             () ->{
                 return new Usuario();
             }
         );
     }
     catch(Exception ex){
         System.out.println("No se pudo actualizar el objeto en la base de datos");
         
     }
     return new Usuario();
 }
 

 @DeleteMapping("/usuario/{id}")
 public ResponseEntity<RespuestaGenerica> deleteUsuario(@PathVariable Long id){
     rusuario.deleteById(id);
     List<Usuario> data = new ArrayList<Usuario>();
     RespuestaGenerica<Usuario> respuesta = new RespuestaGenerica<Usuario>("Usuario eliminada exitosamente", data,0);
     return new ResponseEntity<RespuestaGenerica>(respuesta, HttpStatus.OK);
 }

/* @GetMapping("/listarid/{id}")
 public ResponseEntity<RespuestaGenerica>getusuariosIdentificacion(@PathVariable Long id){
     List<Usuario>lista= rusuario.findAllById(id);
     RespuestaGenerica<Usuario> respuesta=new RespuestaGenerica<>("Listado generado exitosamente", lista, 0);
     return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
          
      
 }*/
}
