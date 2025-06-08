package com.biblioteca.servicios;

import com.biblioteca.entidades.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AutorService {

    private EntityManagerFactory emf;

    public AutorService() {
        // "BibliotecaPU" debe coincidir con el nombre de tu persistence-unit en persistence.xml
        emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    }

    // Método para agregar un autor
    public void agregarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(autor); // Guarda el autor en la base de datos
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para listar todos los autores (útil para comboboxes)
    public List<Autor> listarAutores() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Autor> query = em.createQuery("SELECT a FROM Autor a", Autor.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Puedes añadir más métodos para buscar, actualizar o eliminar autores si los necesitas
}