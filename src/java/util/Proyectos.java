/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author KennyQuevedo
 */
public class Proyectos {
    
    /**
     * representa el id del proyecto
     */
    
    private int id;
    /**
     * representa el documento del titular del proyecto
     */
    
    private String documento;
    /**
     * representa el titulo del proyecto
     */
    
    private String titulo;
    
    /**
     * representa el nombre del proyecto
     */
    private String nombre;
    
    /**
     * representa la descripcion del proyecto
     */
    private String descripcion;
    
    /**
     * representa el email
     */
    private String email;
    
    /**
     * representa el telefono
     */
    private String telefono;
    
    /**
     * contructor vacio
     */
    public Proyectos() {
    }
    
    /**
     * construcctor con las propiedades de la clase
     * @param titulo
     */
    public Proyectos(String titulo) {
        this.titulo = titulo;
    }

    /**
     * construcctor con las propiedades de la clase
     * @param id
     * @param documento
     * @param titulo
     * @param nombre
     * @param descripcion
     * @param email
     * @param telefono 
     */
    public Proyectos(int id, String documento, String titulo, String nombre, String descripcion, String email, String telefono) {
        this.id = id;
        this.documento = documento;
        this.titulo = titulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
