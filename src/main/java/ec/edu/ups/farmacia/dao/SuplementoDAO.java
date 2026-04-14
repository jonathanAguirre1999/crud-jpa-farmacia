package ec.edu.ups.farmacia.dao;

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
            em.persist(suplemento);
            em.getTransaction().commit();
            System.out.println("Suplemento creado correctamente");
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

}
