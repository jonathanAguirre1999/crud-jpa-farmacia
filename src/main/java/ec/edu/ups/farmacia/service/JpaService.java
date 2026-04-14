package ec.edu.ups.farmacia.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaService {

    private static final EntityManagerFactory emf;
    static {
        try{
            emf = Persistence.createEntityManagerFactory("FarmaciaPU");
            System.out.println("Conexion exitosa");
        } catch (Throwable e) {
            System.out.println("Error al conectar: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close(){
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("EMF cerrado correctamente");
        }
    }
}
