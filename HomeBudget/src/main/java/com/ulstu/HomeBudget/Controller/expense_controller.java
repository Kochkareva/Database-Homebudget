package com.ulstu.HomeBudget.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Service.expense_service;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class expense_controller {
    private final expense_service expense_service;

    public expense_controller(expense_service expense_service) {
        this.expense_service = expense_service;
    }

    @GetMapping("/{id}")
    public expense get_expense(@PathVariable Long id) {
        return expense_service.find_expense(id);
    }

    @GetMapping("/")
    public List<expense> get_all_expenses() {
        return expense_service.find_All_expense();
    }

    /**
     *     Date date_operation;
     *     int summa;
     */
    @PostMapping("/")
    public expense create_expense(@RequestParam("date_operation") Date date_operation,
                                                    @RequestParam("summa") int summa) {
        return expense_service.add_expense(date_operation, summa);
    }

    @PatchMapping("/{id}")
    public expense update_expense(@PathVariable Long id,
                                  @RequestParam("date_operation") Date date_operation,
                                  @RequestParam("summa") int summa) {
        return expense_service.update_expense(id, date_operation, summa);
    }

    @DeleteMapping("/{id}")
    public expense delete_expense(@PathVariable Long id) {
        return expense_service.delete_expense(id);
    }
}
