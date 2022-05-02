package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.revenue;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ulstu.HomeBudget.HibernateSessionFactoryUtil;

public class revenue_controller {
    public revenue findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(revenue.class, id);
    }

    public void save(revenue revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(revenue);
        tx1.commit();
        session.close();
    }

    public void update(revenue revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(revenue);
        tx1.commit();
        session.close();
    }

    public void delete(revenue revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(revenue);
        tx1.commit();
        session.close();
    }

    public List<revenue> findAll() {
        List<revenue> revenues = (List<revenue>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From revenue").list();
        return revenues;
    }
}
