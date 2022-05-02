package com.ulstu.HomeBudget.Service;

import com.ulstu.HomeBudget.Controller.source_revenue_controller;
import com.ulstu.HomeBudget.Model.source_revenue;

import java.util.List;

public class source_revenue_service {
    private source_revenue_controller source_revenue_controller = new source_revenue_controller();

    public source_revenue_service() {
    }

    public source_revenue find_source_revenue(int id) {
        return source_revenue_controller.findById(id);
    }

    public void save_source_revenue(source_revenue source_revenue) {
        source_revenue_controller.save(source_revenue);
    }

    public void delete_source_revenue(source_revenue source_revenue) {
        source_revenue_controller.delete(source_revenue);
    }

    public void update_source_revenue(source_revenue source_revenue) {
        source_revenue_controller.update(source_revenue);
    }

    public List<source_revenue> find_All_source_revenues() {
        return source_revenue_controller.findAll();
    }
}
