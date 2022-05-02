package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Controller.expense_controller;
import com.ulstu.HomeBudget.Model.expense;

import java.util.List;

public class expense_service {
    private expense_controller expense_controller = new expense_controller();

    public expense_service() {
    }

    public expense find_expense(int id) {
        return expense_controller.findById(id);
    }

    public void save_expense(expense expense) {
        expense_controller.save(expense);
    }

    public void delete_expense(expense expense) {
        expense_controller.delete(expense);
    }

    public void update_expense(expense expense) {
        expense_controller.update(expense);
    }

    public List<expense> find_All_expenses() {
        return expense_controller.findAll();
    }
}
