package com.ulstu.HomeBudget.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class family_member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    String surname;
    String middle_name;
    String name;
    int age;
    String email;
    @ManyToMany
    @JoinTable(name="familyMember_Revenue",
            joinColumns = @JoinColumn(name ="family_member_fk"),
            inverseJoinColumns = @JoinColumn(name = "revenues"))
    private List<revenue> revenues = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="familyMember_Expense",
            joinColumns = @JoinColumn(name ="family_member_fk"),
            inverseJoinColumns = @JoinColumn(name = "expenses"))
    private List<expense> expenses = new ArrayList<>();

    public family_member(String surname, String middle_name, String name,
                         int age, String email) {
        this.surname = surname;
        this.middle_name = middle_name;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() { return id;}

    public String getSurname(){ return surname;}
    public void setSurname(String surname){this.surname = surname;}

    public String getMiddle_name(){return middle_name;}
    public void setMiddle_name(String middle_name){this.middle_name = middle_name;}

    public String getName(){return name;}
    public void setName(String name){ this.name = name;}

    public int getAge(){return age;}
    public void setAge(int age){this.age =age;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "family_member{" +
                "id = " + id +
                ", surname = '" + surname + '\'' +
                ", middle_name = '" + middle_name + '\'' +
                ", name = '" + name + '\'' +
                ", age = '" + age + '\'' +
                ", email = '" + email + '\'' +
                '}';
    }

    public void setRevenues (List<revenue> revenues)
    {
        this.revenues = revenues;
    }
    public void addRevenues(revenue revenue) {
        revenues.add(revenue);
        if (!revenue.getFamily_members().contains(this)) {
            revenue.addFamily_member(this);
        }
    }
    public List<revenue> getRevenues(){return this.revenues;}

    public void setExpenses (List<expense> expenses)
    {
        this.expenses = expenses;
    }
    public void addExpenses(expense expense) {
        expenses.add(expense);
        if (!expense.getFamily_members().contains(this)) {
            expense.addFamily_member(this);
        }
    }
    public List<expense> getExpenses(){return this.expenses;}
}
