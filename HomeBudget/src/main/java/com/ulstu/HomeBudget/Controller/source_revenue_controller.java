package com.ulstu.HomeBudget.Controller;

import com.ulstu.HomeBudget.Model.family_member;
import com.ulstu.HomeBudget.Service.family_member_service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ulstu.HomeBudget.Model.source_revenue;
import com.ulstu.HomeBudget.Service.source_revenue_service;

import java.util.List;

@RestController
@RequestMapping("/source_revenue")
public class source_revenue_controller {
    private final source_revenue_service source_revenue_service;

    public source_revenue_controller(source_revenue_service source_revenue_service) {
        this.source_revenue_service = source_revenue_service;
    }

    @GetMapping("/{id}")
    public source_revenue get_source_revenue(@PathVariable Long id) {
        return source_revenue_service.find_source_revenue(id);
    }

    @GetMapping("/")
    public List<source_revenue> get_all_source_revenues() {
        return source_revenue_service.find_All_source_revenue();
    }

    /**
     * String name_source;
     * String type_source;
     * String regularity;
     * String nature_receipt;
     * String real_form;
     */
    @PostMapping("/")
    public source_revenue create_source_revenue(@RequestParam("name_source") String name_source,
                                                @RequestParam("type_source") String type_source,
                                                @RequestParam("regularity") String regularity,
                                                @RequestParam("nature_receipt") String nature_receipt,
                                                @RequestParam("real_form") String real_form) {
        return source_revenue_service.add_source_revenue(name_source, type_source, regularity, nature_receipt, real_form);
    }

    @PatchMapping("/{id}")
    public source_revenue update_source_revenue(@PathVariable Long id,
                                                @RequestParam("name_source") String name_source,
                                                @RequestParam("type_source") String type_source,
                                                @RequestParam("regularity") String regularity,
                                                @RequestParam("nature_receipt") String nature_receipt,
                                                @RequestParam("real_form") String real_form) {
        return source_revenue_service.update_source_revenue(id, name_source, type_source, regularity, nature_receipt, real_form);
    }

    @DeleteMapping("/{id}")
    public source_revenue delete_source_revenue(@PathVariable Long id) {
        return source_revenue_service.delete_source_revenue(id);
    }
}
