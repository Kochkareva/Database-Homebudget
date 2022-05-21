package com.ulstu.HomeBudget;

import com.ulstu.HomeBudget.Controller.*;
import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Model.revenue;
import com.ulstu.HomeBudget.Model.source_revenue;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulstu.HomeBudget.Model.family_member;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

@SpringBootApplication
public class HomeBudgetApplication {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(category_expense.class)
                .addAnnotatedClass(expense.class)
                .addAnnotatedClass(family_member.class)
                .addAnnotatedClass(revenue.class)
                .addAnnotatedClass(source_revenue.class)
                .buildSessionFactory();

       /* Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        while (menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("------------------------------ Work with family_member: 1 ----------------------------------------");
            System.out.println("------------------------------ Work with expense: 2 ----------------------------------------------");
            System.out.println("------------------------------ Work with revenue: 3 ----------------------------------------------");
            System.out.println("------------------------------ Work with source_revenue: 4 ---------------------------------------");
            System.out.println("------------------------------ Work with category_expense: 5 -------------------------------------");
            System.out.println("------------------------------ Exit: 0 -----------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            if (menu == 1) {
                family_member_controller fm_controller = new family_member_controller(sessionFactory);
            }
            if (menu == 2) {
                expense_controller ex_contoller = new expense_controller(sessionFactory);
            }
            if (menu == 3) {
                revenue_controller rev_contoller = new revenue_controller(sessionFactory);
            }
            if (menu == 4) {
                source_revenue_controller sr_contoller = new source_revenue_controller(sessionFactory);
            }
            if (menu == 5) {
                category_expense_controller ce_controller = new category_expense_controller(sessionFactory);
            }
        }
        sessionFactory.close();

        */

        category_expense_controller ce_controller = new category_expense_controller(sessionFactory);
    }
}
