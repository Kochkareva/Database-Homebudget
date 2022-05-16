package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.category_expense;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ulstu.HomeBudget.HibernateSessionFactoryUtil;

public class category_expense_controller {

  /*  public category_expense findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(category_expense.class, id);
    }

    public void save(category_expense category_expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(category_expense);
        tx1.commit();
        session.close();
    }

    public void update(category_expense category_expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(category_expense);
        tx1.commit();
        session.close();
    }

    public void delete(category_expense category_expense) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(category_expense);
        tx1.commit();
        session.close();
    }

    public List<category_expense> findAll() {
        List<category_expense> category_expenses = (List<category_expense>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From category_expense").list();
        return category_expenses;
    }*/
}

