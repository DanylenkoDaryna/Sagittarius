package com.vdata.sagittarius.dao;

import com.vdata.sagittarius.entity.PhysicalClient;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PhysicalClientDao {

    public void create(PhysicalClient entity) {

        Session session1 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session1.beginTransaction();

        session1.save(entity);

        tr.commit();
        session1.close();
    }


    public PhysicalClient read(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PhysicalClient.class, id);
    }

    public void update(PhysicalClient entity) {
        Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Transaction tr2 = session2.beginTransaction();
        session2.update(entity);
        tr2.commit();
        session2.close();
    }

    public void delete(PhysicalClient entity) {

        Session session3 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr3 = session3.beginTransaction();
        session3.delete(entity);

        tr3.commit();
        session3.close();

    }
}
