package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Model.source_revenue;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class source_revenue_service {
    public void create_source_revenue(Session session, source_revenue source_revenue) {
        source_revenue sr = source_revenue;
        session.save(sr);
    }

    public void update_source_revenue(Session session, int id) {
        source_revenue sr = session.get(source_revenue.class, id);
        System.out.println(sr);
        System.out.println("Enter name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sr.setName_source(name);
        System.out.println("Enter type source: ");
        String source = sc.nextLine();
        sr.setType_source(source);
        System.out.println("Enter regularity: ");
        String regularity = sc.nextLine();
        sr.setRegularity(regularity);
        System.out.println("Enter nature receipt: ");
        String nature = sc.nextLine();
        sr.setNature_receipt(nature);
        System.out.println("Enter real form");
        String form = sc.nextLine();
        sr.setReal_form(form);
        session.save(sr);
    }

    public void delete_source_revenue(Session session, int id) {
        System.out.println(get_source_revenues(session));
        source_revenue sr = session.get(source_revenue.class, id);
        session.delete(sr);
    }

    public List<source_revenue> get_source_revenues(Session session) {
        List<source_revenue> sr = session.createCriteria(source_revenue.class).list();
        System.out.println("\n\n--------------------------------------------------------------------------------------------------");
        for (var item : sr) {
            System.out.println("id = " + item.getId() +
                    ", name_source = '" + item.getName_source() + '\'' +
                    ", type_source = '" + item.getType_source() + '\'' +
                    ", regularity = '" + item.getRegularity() + '\'' +
                    ", nature_receipt = '" + item.getNature_receipt() + '\'' +
                    ", real_form = '" + item.getReal_form());

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n\n");
        return sr;
    }
}