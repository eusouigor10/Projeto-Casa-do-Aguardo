package com.domingos.jv.casaaguardo;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import jakarta.persistence.EntityManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;

public class CasaAguardo {

    public static void main(String[] args) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateUtil.createEntityManager();

            System.out.println("Conexão com Hibernate estabelecida!");

            Long quantidade = entityManager
                    .createQuery(
                            "SELECT COUNT(p) FROM Pessoa p",
                            Long.class
                    )
                    .getSingleResult();

            System.out.println("Quantidade de pessoas: " + quantidade);

        } catch (Exception e) {

            System.out.println("Erro ao iniciar o Hibernate:");
            e.printStackTrace();

        } finally {

            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }

            HibernateUtil.close();
        }
    }
}
