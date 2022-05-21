package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Controller.revenue_controller;
import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Model.revenue;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class revenue_service {
    public void create_revenue(Session session, revenue revenue) {
        revenue ex = revenue;
        session.save(ex);
    }

    public void update_revenue(Session session, int id){
        revenue rev = session.get(revenue.class, id);
        System.out.println(rev);
        System.out.println("Enter sum: ");
        Scanner sc = new Scanner(System.in);
        int new_summa = sc.nextInt();
        rev.setSumma(new_summa);
        session.save(rev);
    }

    public void delete_revenue(Session session, int id){
        System.out.println(get_revenues(session));
        revenue rev = session.get(revenue.class, id);
        session.delete(rev);
    }

    public List<revenue> get_revenues(Session session){
        List<revenue> rev = session.createCriteria(revenue.class).list();
        System.out.println("\n\n--------------------------------------------------------------------------------------------------");
        for (var item : rev){
            System.out.println("id = " + item.getId() +
                    ", date_operation = '" + item.getDate_operation() + '\'' +
                    ", summa = '" + item.getSumma());

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n\n");
        return rev;
    }
}
