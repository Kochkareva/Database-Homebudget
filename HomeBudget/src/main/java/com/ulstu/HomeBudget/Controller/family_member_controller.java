package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.family_member;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.ulstu.HomeBudget.HibernateSessionFactoryUtil;

import javax.persistence.EntityManagerFactory;

public class family_member_controller {

/*
    public family_member findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        family_member family_members = (family_member) session.get(family_member.class, id);
        session.getTransaction().commit();
        return family_members;


        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(family_member.class, id);
    }

    public void save(family_member family_member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(family_member);
        tx1.commit();
        session.close();
    }

    public void update(family_member family_member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(family_member);
        tx1.commit();
        session.close();
    }

    public void delete(family_member family_member) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(family_member);
        tx1.commit();
        session.close();
    }

    public List<family_member> findAll() {
        List<family_member> family_members = (List<family_member>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From family_member").list();
        return family_members;
    }

 */
}
