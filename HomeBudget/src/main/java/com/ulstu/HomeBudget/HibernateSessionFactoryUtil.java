package com.ulstu.HomeBudget;

import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Model.family_member;
import com.ulstu.HomeBudget.Model.revenue;
import com.ulstu.HomeBudget.Model.source_revenue;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(category_expense.class);
                configuration.addAnnotatedClass(expense.class);
                configuration.addAnnotatedClass(family_member.class);
                configuration.addAnnotatedClass(revenue.class);
                configuration.addAnnotatedClass(source_revenue.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
