package com.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne; // Para la relación N a 1 con Autor
import javax.persistence.JoinColumn; // Para especificar la columna de unión
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer anio; // No uses 'año' directamente por caracteres especiales
    private String id_autor; // La relación se hace con el objeto Autor, no con su ID directamente

    @ManyToOne // Muchos libros pueden ser escritos por un autor
    @JoinColumn(name = "autor_id") // Nombre de la columna en la tabla LIBRO que guardará el ID del autor
    private Autor autor; // Relación con la entidad Autor

    // Constructor vacío (requerido por JPA)
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(String titulo, Integer anio, Autor autor) {
        this.titulo = titulo;
        this.anio = anio;
        this.autor = autor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Libro{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", autor=" + (autor != null ? autor.getNombre() : "N/A") + // Mostrar el nombre del autor
               '}';
    }
}