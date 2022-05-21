package com.ulstu.HomeBudget.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "family_member", schema = "public", catalog = "test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class family_member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private int family_id;
    @Column(name = "surname")
    String _surname;
    @Column(name = "middle_name")
    String _middle_name;
    @Column(name = "name_member")
    String name_member;
    @Column(name = "age")
    int _age;
    @Column(name = "email")
    String _email;
    @ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinTable(name="familyMember_revenue",
            joinColumns = @JoinColumn(name ="familymember_id"),
            inverseJoinColumns = @JoinColumn(name = "revenue_id"))
    List<revenue> revenues = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="familyMember_expense",
            joinColumns = @JoinColumn(name ="familymember_id"),
            inverseJoinColumns = @JoinColumn(name = "expenses_id"))
    List<expense> expenses = new ArrayList<>();


    public family_member(String surname, String middle_name, String name_member,
                         int age, String email) {
        this._surname = surname;
        this._middle_name = middle_name;
        this.name_member = name_member;
        this._age = age;
        this._email = email;
    }

    public int getId() { return family_id;}

    public String getSurname(){ return _surname;}
    public void setSurname(String surname){this._surname = surname;}

    public String getMiddle_name(){return _middle_name;}
    public void setMiddle_name(String middle_name){this._middle_name = middle_name;}

    public String getName(){return name_member;}
    public void setName(String name){ this.name_member = name;}

    public int getAge(){return _age;}
    public void setAge(int age){this._age =age;}

    public String getEmail(){return _email;}
    public void setEmail(String email){this._email = email;}

    @Override
    public int hashCode() {
        return Objects.hash(family_id);
    }

    @Override
    public String toString() {
        return "family_member{" +
                "id = " + family_id +
                ", surname = '" + _surname + '\'' +
                ", middle_name = '" + _middle_name + '\'' +
                ", name = '" + name_member + '\'' +
                ", age = '" + _age + '\'' +
                ", email = '" + _email + '\'' +
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
