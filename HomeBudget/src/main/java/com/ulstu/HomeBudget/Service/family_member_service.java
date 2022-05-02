package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Controller.family_member_controller;
import com.ulstu.HomeBudget.Model.family_member;

import java.util.List;

public class family_member_service {
    private family_member_controller family_member_controller = new family_member_controller();

    public family_member_service() {
    }

    public family_member find_family_member(int id) {
        return family_member_controller.findById(id);
    }

    public void save_family_member(family_member family_member) {
        family_member_controller.save(family_member);
    }

    public void delete_family_member(family_member family_member) {
        family_member_controller.delete(family_member);
    }

    public void update_family_member(family_member family_member) {
        family_member_controller.update(family_member);
    }

    public List<family_member> find_All_family_members() {
        return family_member_controller.findAll();
    }
}
