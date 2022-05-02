package com.ulstu.HomeBudget.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ulstu.HomeBudget.Model.category_expense;
import com.ulstu.HomeBudget.Service.category_expense_service;

import java.util.List;

@RestController
@RequestMapping("/category_expense")
public class category_expense_controller {
    private final category_expense_service category_expense_service;

    public category_expense_controller(category_expense_service category_expense_service) {
        this.category_expense_service = category_expense_service;
    }

    @GetMapping("/{id}")
    public category_expense get_category_expense(@PathVariable Long id) {
        return category_expense_service.find_category_expense(id);
    }

    @GetMapping("/")
    public List<category_expense> get_all_category_expenses() {
        return category_expense_service.find_All_category_expense();
    }

    /**
     * String category;
     * int limits;
     * int passibility_planning;
     * int category_necessity;
     */
    @PostMapping("/")
    public category_expense create_category_expense(@RequestParam("category") String category,
                                                    @RequestParam("limits") int limits,
                                                    @RequestParam("passibility_planning") int passibility_planning,
                                                    @RequestParam("category_necessity") int category_necessity) {
        return category_expense_service.add_category_expense(category, limits, passibility_planning, category_necessity);
    }

    @PatchMapping("/{id}")
    public category_expense update_category_expense(@PathVariable Long id,
                                                    @RequestParam("category") String category,
                                                    @RequestParam("limits") int limits,
                                                    @RequestParam("passibility_planning") int passibility_planning,
                                                    @RequestParam("category_necessity") int category_necessity) {
        return category_expense_service.update_category_expense(id, category, limits, passibility_planning, category_necessity);
    }

    @DeleteMapping("/{id}")
    public category_expense delete_category_expense(@PathVariable Long id) {
        return category_expense_service.delete_category_expense(id);
    }
}

