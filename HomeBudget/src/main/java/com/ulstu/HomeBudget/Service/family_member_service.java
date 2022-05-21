package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Model.family_member;
import org.hibernate.Session;
import java.util.List;

public class family_member_service {

    public void create_family_member(Session session, family_member family_member) {
        family_member fm = family_member;
        session.save(fm);
    }

    public void update_family_member(Session session, int id){
        family_member fm = session.get(family_member.class, id);
        System.out.println(fm);
        String new_name = "Петя";
        fm.setName(new_name);
        session.save(fm);
    }

    public void delete_family_member(Session session, int id){
        System.out.println(get_family_members(session));
        family_member fm = session.get(family_member.class, id);
        session.delete(fm);
    }

    public List<family_member> get_family_members(Session session){
        List<family_member> fm = session.createCriteria(family_member.class).list();
        System.out.println("\n\n--------------------------------------------------------------------------------------------------");
        for (var item : fm){
            System.out.println("id = " + item.getId() +
                    ", surname = '" + item.get_surname() + '\'' +
                    ", middle_name = '" + item.get_middle_name() + '\'' +
                    ", name = '" + item.getName() + '\'' +
                    ", age = '" + item.getAge() + '\'' +
                    ", email = '" + item.getEmail());

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n\n");
        return fm;
    }
}
