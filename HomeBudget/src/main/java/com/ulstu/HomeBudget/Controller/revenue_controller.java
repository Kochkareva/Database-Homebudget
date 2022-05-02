package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.expense;
import com.ulstu.HomeBudget.Service.expense_service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ulstu.HomeBudget.Model.revenue;
import com.ulstu.HomeBudget.Service.revenue_service;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/revenue")
public class revenue_controller {
    private final revenue_service revenue_service;

    public revenue_controller(revenue_service revenue_service) {
        this.revenue_service = revenue_service;
    }

    @GetMapping("/{id}")
    public revenue get_revenue(@PathVariable Long id) {
        return revenue_service.find_revenue(id);
    }

    @GetMapping("/")
    public List<revenue> get_all_revenues() {
        return revenue_service.find_All_revenue();
    }

    /**
     *     Date date_operation;
     *     int summa;
     */
    @PostMapping("/")
    public revenue create_revenue(@RequestParam("date_operation") Date date_operation,
                                  @RequestParam("summa") int summa) {
        return revenue_service.add_revenue(date_operation, summa);
    }

    @PatchMapping("/{id}")
    public revenue update_revenue(@PathVariable Long id,
                                  @RequestParam("date_operation") Date date_operation,
                                  @RequestParam("summa") int summa) {
        return revenue_service.update_revenue(id, date_operation, summa);
    }

    @DeleteMapping("/{id}")
    public revenue delete_revenue(@PathVariable Long id) {
        return revenue_service.delete_revenue(id);
    }
}
