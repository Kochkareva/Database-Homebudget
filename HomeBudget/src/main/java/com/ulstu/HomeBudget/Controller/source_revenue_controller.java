package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.source_revenue;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ulstu.HomeBudget.HibernateSessionFactoryUtil;

public class source_revenue_controller {
  /*  public source_revenue findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(source_revenue.class, id);
    }

    public void save(source_revenue source_revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(source_revenue);
        tx1.commit();
        session.close();
    }

    public void update(source_revenue source_revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(source_revenue);
        tx1.commit();
        session.close();
    }

    public void delete(source_revenue source_revenue) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(source_revenue);
        tx1.commit();
        session.close();
    }

    public List<source_revenue> findAll() {
        List<source_revenue> source_revenues = (List<source_revenue>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From source_revenue").list();
        return source_revenues;
    }*/
}
