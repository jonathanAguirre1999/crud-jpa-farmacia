package ec.edu.ups.farmacia.dao;

import ec.edu.ups.farmacia.model.Categoria;
import ec.edu.ups.farmacia.model.Laboratorio;
import ec.edu.ups.farmacia.model.Suplemento;
import ec.edu.ups.farmacia.service.JpaService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SuplementoDAO {

    //CREAR
    public void crear(Suplemento suplemento) {
        EntityManager em = JpaService.getEntityManager();
        try{
            em.getTransaction().begin();

            if (suplemento.getCategoria() != null && suplemento.getCategoria().getId() != null) {
                suplemento.setCategoria(em.getReference(Categoria.class, suplemento.getCategoria().getId()));
            }
            if (suplemento.getLaboratorio() != null && suplemento.getLaboratorio().getId() != null) {
                suplemento.setLaboratorio(em.getReference(Laboratorio.class, suplemento.getLaboratorio().getId()));
            }

            em.persist(suplemento);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al crear el suplemento: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //LEER UN SUPLEMENTO EN ESPECIFICO POR ID
    public Suplemento buscarPorId(Long id) {
        EntityManager em = JpaService.getEntityManager();
        try{
            return em.find(Suplemento.class, id);
        } finally {
            em.close();
        }
    }

    //LEER TODOS LOS SUPLEMENTOS
    public List<Suplemento> obtenerTodos() {
        EntityManager em = JpaService.getEntityManager();
        try{
            return em.createQuery("SELECT m FROM Suplemento m", Suplemento.class).getResultList();
        } finally {
            em.close();
        }
    }

    //ACTUALIZAR
    public void actualizar(Suplemento suplemento) {
        EntityManager em = JpaService.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(suplemento);
            em.getTransaction().commit();
            System.out.println("Suplemento actualizado correctamente");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al actualizar el suplemento: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //ELIMINAR
    public void eliminar(Long id) {
        EntityManager em = JpaService.getEntityManager();
        try{
            em.getTransaction().begin();
            Suplemento suplemento = em.find(Suplemento.class, id);
            if (suplemento != null) {
                em.remove(suplemento);
                System.out.println("Suplemento eliminado correctamente");
            } else {
                System.out.println("Suplemento con id " + id + " no encontrado");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al eliminar el suplemento: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public List<Suplemento> obtenerReportePorCategoria(String tipoCategoria) {
        EntityManager em = JpaService.getEntityManager();
        try {
            String jpql = "SELECT s FROM Suplemento s " +
                    "JOIN FETCH s.categoria c " +
                    "JOIN FETCH s.laboratorio l " +
                    "WHERE c.tipoSuplemento = :categoria " +
                    "ORDER BY s.precio DESC";
            return em.createQuery(jpql, Suplemento.class)
                    .setParameter("categoria", tipoCategoria)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> obtenerEstadisticasLaboratorio() {
        EntityManager em = JpaService.getEntityManager();
        try {
            String jpql = "SELECT l.nombre, COUNT(s.id), MAX(s.precio) " +
                    "FROM Laboratorio l " +
                    "LEFT JOIN l.suplementos s " +
                    "GROUP BY l.nombre " +
                    "HAVING COUNT(s.id) > 0 " +
                    "ORDER BY l.nombre ASC";
            return em.createQuery(jpql, Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Suplemento> obtenerCatalogoPaginado(int stockMinimo, int numeroPagina, int tamanoPagina) {
        EntityManager em = JpaService.getEntityManager();
        try {
            String jpql = "SELECT s FROM Suplemento s " +
                    "WHERE s.stock > :stockMinimo " +
                    "ORDER BY s.nombre ASC";

            int primerResultado = (numeroPagina - 1) * tamanoPagina;

            return em.createQuery(jpql, Suplemento.class)
                    .setParameter("stockMinimo", stockMinimo)
                    .setFirstResult(primerResultado)
                    .setMaxResults(tamanoPagina)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
