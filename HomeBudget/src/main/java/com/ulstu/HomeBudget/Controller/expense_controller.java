package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.expense;
import java.util.*;
import com.ulstu.HomeBudget.Service.expense_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class expense_controller {
    private expense_service ex_service;

    public expense_controller(SessionFactory sessionFactory) {
        Date date = new Date();

        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        while (menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("-------------------------------- create new expense: 1 -------------------------------------------");
            System.out.println("-------------------------------- update expense: 2 -----------------------------------------------");
            System.out.println("-------------------------------- delete expense: 3 -----------------------------------------------");
            System.out.println("-------------------------------- Exit: 0 ---------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            ex_service = new expense_service();
            if (menu == 1) {
                System.out.println("Enter sum: ");
                Scanner sc = new Scanner(System.in);
                int summa = sc.nextInt();
                expense ex = new expense(date, summa);
                ex_service.create_expense(session, ex);
            }
            if (menu == 2){
                ex_service.get_expenses(session);
                System.out.println("Enter id expense: ");
                Scanner sc = new Scanner(System.in);
                int id_expense= sc.nextInt();
                ex_service.update_expense(session, id_expense);
            }
            if(menu == 3){
                ex_service.get_expenses(session);
                System.out.println("Enter id category: ");
                Scanner sc = new Scanner(System.in);
                int id_expense = sc.nextInt();
                ex_service.delete_expense(session, id_expense);
            }
            session.getTransaction().commit();
        }
    }
}