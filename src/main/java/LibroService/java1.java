package com.biblioteca.servicios;

import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibroService {

    private EntityManagerFactory emf;

    public LibroService() {
        emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    }

    // Método para agregar un libro asociado a un autor
    public void agregarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            // Si el autor del libro no está en la base de datos (es un objeto nuevo), persistirlo primero
            // Aunque en nuestro UI seleccionaremos un autor existente, es una buena práctica.
            // Si el autor ya tiene un ID, no es necesario persistirlo de nuevo.
            if (libro.getAutor() != null && libro.getAutor().getId() == null) {
                em.persist(libro.getAutor());
            }
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para listar todos los libros
    public List<Libro> listarTodosLosLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.autor", Libro.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para listar todos los libros de un autor específico
    public List<Libro> listarLibrosPorAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autor = :autor", Libro.class);
            query.setParameter("autor", autor);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}