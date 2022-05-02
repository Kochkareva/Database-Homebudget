package com.ulstu.HomeBudget.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ulstu.HomeBudget.Model.family_member;
import com.ulstu.HomeBudget.Service.family_member_service;

import java.util.List;

@RestController
@RequestMapping("/family_member")
public class family_member_controller {
    private final family_member_service family_member_service;

    public family_member_controller(family_member_service family_member_service) {
        this.family_member_service = family_member_service;
    }

    @GetMapping("/{id}")
    public family_member get_family_member(@PathVariable Long id) {
        return family_member_service.find_family_member(id);
    }

    @GetMapping("/")
    public List<family_member> get_all_family_members() {
        return family_member_service.find_All_family_member();
    }

    /**
     *     String surname;
     *     String middle_name;
     *     String name;
     *     int age;
     *     String email;
     */
    @PostMapping("/")
    public family_member create_family_member(@RequestParam("surname") String surname,
                                              @RequestParam("middle_name") String middle_name,
                                              @RequestParam("name") String name,
                                              @RequestParam("age") int age,
                                              @RequestParam("email") String email) {
        return family_member_service.add_family_member(surname, middle_name, name, age, email);
    }

    @PatchMapping("/{id}")
    public family_member update_family_member(@PathVariable Long id,
                                              @RequestParam("surname") String surname,
                                              @RequestParam("middle_name") String middle_name,
                                              @RequestParam("name") String name,
                                              @RequestParam("age") int age,
                                              @RequestParam("email") String email) {
        return family_member_service.update_family_member(id, surname, middle_name, name, age, email);
    }

    @DeleteMapping("/{id}")
    public family_member delete_family_member(@PathVariable Long id) {
        return family_member_service.delete_family_member(id);
    }
}
