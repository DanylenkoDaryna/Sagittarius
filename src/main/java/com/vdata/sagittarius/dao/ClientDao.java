package com.vdata.sagittarius.dao;

import com.vdata.sagittarius.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class ClientDao {


    public void create(Client entity) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(entity);
        tr.commit();
        session.close();
    }


    public Client read(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Client.class, id);
    }

    public void update(Client entity) {
           Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
           Transaction tr2 = session.beginTransaction();
           session.update(entity);
           tr2.commit();
           session.close();
    }

    public void delete(Client entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr3 = session.beginTransaction();
        session.delete(entity);
        tr3.commit();
        session.close();
    }
}
