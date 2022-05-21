package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.source_revenue;
import com.ulstu.HomeBudget.Service.source_revenue_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class source_revenue_controller {
    private source_revenue_service sr_service;

    public source_revenue_controller(SessionFactory sessionFactory) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        while (menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("----------------------------- create new source_revenue: 1 ---------------------------------------");
            System.out.println("----------------------------- update source_revenue: 2 -------------------------------------------");
            System.out.println("----------------------------- delete source_revenue: 3 -------------------------------------------");
            System.out.println("----------------------------- Exit: 0 ------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            sr_service = new source_revenue_service();
            if (menu == 1) {
                System.out.println("Enter name: ");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                System.out.println("Enter type source: ");
                String source = sc.nextLine();
                System.out.println("Enter regularity: ");
                String regularity = sc.nextLine();
                System.out.println("Enter nature receipt: ");
                String nature = sc.nextLine();
                System.out.println("Enter real form");
                String form = sc.nextLine();
                source_revenue sr = new source_revenue(name, source, regularity, nature, form);
                sr_service.create_source_revenue(session, sr);
            }
            if (menu == 2) {
                sr_service.get_source_revenues(session);
                System.out.println("Enter id source: ");
                Scanner sc = new Scanner(System.in);
                int id_source = sc.nextInt();
                sr_service.update_source_revenue(session, id_source);
            }
            if (menu == 3) {
                sr_service.get_source_revenues(session);
                System.out.println("Enter id source: ");
                Scanner sc = new Scanner(System.in);
                int id_source = sc.nextInt();
                sr_service.delete_source_revenue(session, id_source);
            }
            session.getTransaction().commit();
        }
    }
}
