package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Service.category_expense_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Scanner;

public class category_expense_controller {

    private category_expense_service ce_service;

    public category_expense_controller(SessionFactory sessionFactory) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        int category_menu = scanner.nextInt();
        while (category_menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("----------------------------- create new category_expense: 1 -------------------------------------");
            System.out.println("----------------------------- update category_expense: 2 -----------------------------------------");
            System.out.println("----------------------------- delete category_expense: 3 -----------------------------------------");
            System.out.println("----------------------------- sort category_expenses: 4 ------------------------------------------");
            System.out.println("----------------------------- Exit: 0 ------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            ce_service = new category_expense_service();
            if (category_menu == 1) {
                System.out.println("Enter name: ");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                System.out.println("Enter limits: ");
                int limit = sc.nextInt();
                System.out.println("Enter passibility planning: ");
                int planning = sc.nextInt();
                System.out.println("Enter category necessity: ");
                int necessity = sc.nextInt();
                category_expense ce = new category_expense(name, limit, planning, necessity);
                ce_service.create_category_expense(session, ce);
            }
            if (category_menu == 2){
                ce_service.get_category_expenses(session);
                System.out.println("Enter id category: ");
                Scanner sc = new Scanner(System.in);
                int id_category = sc.nextInt();
                ce_service.update_category_expense(session, id_category);
            }
            if(category_menu == 3){
                ce_service.get_category_expenses(session);
                System.out.println("Enter id category: ");
                Scanner sc = new Scanner(System.in);
                int id_category = sc.nextInt();
                ce_service.delete_category_expense(session, id_category);
            }
            if(category_menu == 4){
                ce_service.get_category_expense_sorted(session);
            }
            session.getTransaction().commit();
        }
    }
}

