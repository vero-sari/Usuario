package com.example.api_rest_vs.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.NonNull;
@Entity
@Table(name = "usuario")
public class Usuario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String clave;
    @Column(nullable = false, length=50, unique=true)
    private String email;
   
    @NonNull
    private String imagenPath;

    @NonNull
    private String cedulaPath;

    @Transient
    private String imagenUrl;

    @Transient
    private String cedulaUrl;
    
    public Usuario(){
    }
         
    public Usuario(Long id, String name, String clave, String email){
        this.id = id;
        this.name = name;
        this.clave = clave;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public Usuario(Long id, String name, String clave, String email, @NonNull String imagenPath,
            @NonNull String cedulaPath, String imagenUrl, String cedulaUrl) {
        this.id = id;
        this.name = name;
        this.clave = clave;
        this.email = email;
        this.imagenPath = imagenPath;
        this.cedulaPath = cedulaPath;
        this.imagenUrl = imagenUrl;
        this.cedulaUrl = cedulaUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getCedulaPath() {
        return cedulaPath;
    }

    public void setCedulaPath(String cedulaPath) {
        this.cedulaPath = cedulaPath;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getCedulaUrl() {
        return cedulaUrl;
    }

    public void setCedulaUrl(String cedulaUrl) {
        this.cedulaUrl = cedulaUrl;
    }

   
 
    
}
