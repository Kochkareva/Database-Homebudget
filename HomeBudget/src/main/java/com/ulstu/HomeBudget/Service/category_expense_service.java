package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.category_expense;
import org.hibernate.Session;
import java.util.List;
import java.util.Scanner;

public class category_expense_service {
    public void create_category_expense(Session session, category_expense category_expense) {
        category_expense ce = category_expense;
        session.save(ce);
    }

    public void update_category_expense(Session session, int id) {
        category_expense ce = session.get(category_expense.class, id);
        System.out.println(ce);
        System.out.println("Enter name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        ce.setCategory(name);
        System.out.println("Enter limits: ");
        int limit = sc.nextInt();
        ce.setLimits(limit);
        System.out.println("Enter passibility planning: ");
        int planning = sc.nextInt();
        ce.setPassibility_planning(planning);
        System.out.println("Enter category necessity: ");
        int necessity = sc.nextInt();
        ce.setCategory_necessity(necessity);
        session.save(ce);
    }

    public void delete_category_expense(Session session, int id) {
        System.out.println(get_category_expenses(session));
        category_expense ce = session.get(category_expense.class, id);
        session.delete(ce);
    }

    public List<category_expense> get_category_expenses(Session session) {
        List<category_expense> ce = session.createCriteria(category_expense.class).list();
        System.out.println("\n\n--------------------------------------------------------------------------------------------------");
        for (var item : ce) {
            System.out.println("id = " + item.getId() +
                    ", category = '" + item.getCategory() + '\'' +
                    ", limits = '" + item.getLimits() + '\'' +
                    ", passibility_planning = '" + item.getPassibility_planning() + '\'' +
                    ", category_necessity = '" + item.getCategory_necessity());

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n\n");
        return ce;
    }

    public List<category_expense> get_category_expense_sorted(Session session) {
        List<category_expense> ce = session.createQuery("Select c from category_expense c where category = \'"
                + "medicine" + '\'', category_expense.class).getResultList();

        for (var item : ce) {
            System.out.println("id = " + item.getId() +
                    ", category = '" + item.getCategory() + '\'' +
                    ", limits = '" + item.getLimits() + '\'' +
                    ", passibility_planning = '" + item.getPassibility_planning() + '\'' +
                    ", category_necessity = '" + item.getCategory_necessity());

        }
        return ce;
    }
}
