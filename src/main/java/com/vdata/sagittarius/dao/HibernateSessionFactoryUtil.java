package com.vdata.sagittarius.dao;

import com.vdata.sagittarius.entity.Client;
import com.vdata.sagittarius.entity.PhysicalClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Утілітний клас
 * У нього всього одна задача - створювати фабрику сесій для роботи з БД (патерн "Factory").
 */
public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){

        if(sessionFactory==null){
                try {
                    Configuration conf = new Configuration().configure();
                    conf.addAnnotatedClass(Client.class);
                    conf.addAnnotatedClass(PhysicalClient.class);
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                             .applySettings(conf.getProperties());
                    sessionFactory = conf.buildSessionFactory(builder.build());

                } catch (Exception e) {
                    System.out.println("Exception!" + e);
                }
        }
        return sessionFactory;
    }
}
