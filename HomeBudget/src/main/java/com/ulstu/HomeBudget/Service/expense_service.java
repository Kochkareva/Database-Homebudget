package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.expense;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class expense_service {
    public void create_expense(Session session, expense expense) {
        expense ex = expense;
        session.save(ex);
    }

    public void update_expense(Session session, int id){
        expense ex = session.get(expense.class, id);
        System.out.println(ex);
        System.out.println("Enter sum: ");
        Scanner sc = new Scanner(System.in);
        int new_summa = sc.nextInt();
        ex.setSumma(new_summa);
        session.save(ex);
    }

    public void delete_expense(Session session, int id){
        System.out.println(get_expenses(session));
        expense ex = session.get(expense.class, id);
        session.delete(ex);
    }

    public List<expense> get_expenses(Session session){
        List<expense> fm = session.createCriteria(expense.class).list();
        System.out.println("\n\n--------------------------------------------------------------------------------------------------");
        for (var item : fm){
            System.out.println("id = " + item.getId() +
                    ", date_operation = '" + item.getDate_operation() + '\'' +
                    ", summa = '" + item.getSumma());

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n\n");
        return fm;
    }
}
