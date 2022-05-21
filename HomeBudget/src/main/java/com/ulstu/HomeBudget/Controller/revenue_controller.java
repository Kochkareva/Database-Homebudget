package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.revenue;

import java.util.Date;
import java.util.Scanner;
import com.ulstu.HomeBudget.Service.revenue_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class revenue_controller {
    private revenue_service rev_service;

    public revenue_controller(SessionFactory sessionFactory) {
        Date date = new Date();

        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        while (menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("-------------------------------- create new revenue: 1 -------------------------------------------");
            System.out.println("-------------------------------- update revenue: 2 -----------------------------------------------");
            System.out.println("-------------------------------- delete revenue: 3 -----------------------------------------------");
            System.out.println("-------------------------------- Exit: 0 ---------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            rev_service = new revenue_service();
            if (menu == 1) {
                System.out.println("Enter sum: ");
                Scanner sc = new Scanner(System.in);
                int summa = sc.nextInt();
                revenue rev = new revenue(date, summa);
                rev_service.create_revenue(session, rev);
            }
            if (menu == 2) {
                rev_service.get_revenues(session);
                System.out.println("Enter id revenue: ");
                Scanner sc = new Scanner(System.in);
                int id_revenue = sc.nextInt();
                rev_service.update_revenue(session, id_revenue);
            }
            if (menu == 3) {
                rev_service.get_revenues(session);
                System.out.println("Enter id revenue: ");
                Scanner sc = new Scanner(System.in);
                int id_revenue = sc.nextInt();
                rev_service.delete_revenue(session, id_revenue);
            }
            session.getTransaction().commit();
        }
    }
}
