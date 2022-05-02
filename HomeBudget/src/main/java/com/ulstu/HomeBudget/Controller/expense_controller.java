package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.expense;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ulstu.HomeBudget.HibernateSessionFactoryUtil;

public class expense_controller {

    public expense findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(expense.class, id);
    }

    public void save(expense expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(expense);
        tx1.commit();
        session.close();
    }

    public void update(expense expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(expense);
        tx1.commit();
        session.close();
    }

    public void delete(expense expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(expense);
        tx1.commit();
        session.close();
    }

    public List<expense> findAll() {
        List<expense> expenses = (List<expense>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From expense").list();
        return expenses;
    }
}
