package com.ulstu.HomeBudget.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class category_expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    String category;
    int limits;
    int passibility_planning;
    int category_necessity;

    public category_expense(String category, int limits, int passibility_planning, int category_necessity){
        this.category=category;
        this.limits=limits;
        this.passibility_planning = passibility_planning;
        this.category_necessity = category_necessity;
    }

    public Long getId() { return id;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}

    public int getLimits(){return limits;}
    public void setLimits(int limits){this.limits=limits;}

    public int getPassibility_planning(){return passibility_planning;}
    public void setPassibility_planning(int passibility_planning){this.passibility_planning=passibility_planning;}

    public int getCategory_necessity(){return category_necessity;}
    public void setCategory_necessity(int category_necessity){this.category_necessity=category_necessity;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "category_expense{" +
                "id = " + id +
                ", category = '" + category + '\'' +
                ", limits = '" + limits + '\'' +
                ", passibility_planning = '" + passibility_planning + '\'' +
                ", category_necessity = '" + category_necessity + '\'' +
                '}';
    }
}
