package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.family_member;
import com.ulstu.HomeBudget.Service.family_member_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class family_member_controller {

    private family_member_service fm_service;

    public family_member_controller(SessionFactory sessionFactory) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        while (menu > 0) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------- Select action ------------------------------------------------");
            System.out.println("----------------------------- create new family_member: 1 ----------------------------------------");
            System.out.println("----------------------------- update family_member: 2 --------------------------------------------");
            System.out.println("----------------------------- delete family_member: 3 --------------------------------------------");
            System.out.println("----------------------------- Exit: 0 ------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            fm_service = new family_member_service();
            if (menu == 1) {
                System.out.println("Enter surname: ");
                Scanner sc = new Scanner(System.in);
                String surname = sc.nextLine();
                System.out.println("Enter middle_name: ");
                String middle_name = sc.nextLine();
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Enter age: ");
                int age = sc.nextInt();
                System.out.println("Enter email: ");
                String email = sc.nextLine();
                family_member fm = new family_member(surname, middle_name, name, age, email);
                fm_service.create_family_member(session, fm);
            }
            if (menu == 2) {
                fm_service.get_family_members(session);
                System.out.println("Enter id family member: ");
                Scanner sc = new Scanner(System.in);
                int id_fm = sc.nextInt();
                fm_service.update_family_member(session, id_fm);
            }
            if (menu == 3) {
                fm_service.get_family_members(session);
                System.out.println("Enter id family member: ");
                Scanner sc = new Scanner(System.in);
                int id_fm = sc.nextInt();
                fm_service.delete_family_member(session, id_fm);
            }
            session.getTransaction().commit();
        }
    }
}
