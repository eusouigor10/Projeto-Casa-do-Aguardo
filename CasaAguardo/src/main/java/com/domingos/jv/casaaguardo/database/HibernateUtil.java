package com.domingos.jv.casaaguardo.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CasaAguardoPU");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if(emf.isOpen()) {
            emf.close();
        }
    }
}
