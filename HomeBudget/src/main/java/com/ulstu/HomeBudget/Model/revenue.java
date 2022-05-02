package com.ulstu.HomeBudget.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    Date date_operation;
    int summa;
    @ManyToOne
    @JoinColumn(name = "revenue_fk")
    private source_revenue source_revenue;
    @ManyToMany(mappedBy = "revenues")
    private List<family_member> family_members = new ArrayList<>();

    public revenue(Date date_operation, int summa){
        this.date_operation = date_operation;
        this.summa = summa;
    }

    public Long getId() { return id;}

    public Date getDate_operation(){return date_operation;}
    public void setDate_operation(Date date_operation){this.date_operation=date_operation;}

    public int getSumma(){return summa;}
    public void setSumma(int summa){this.summa=summa;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "revenue{" +
                "id = " + id +
                ", date_operation = '" + date_operation + '\'' +
                ", summa = '" + summa + '\'' +
                '}';
    }

    public void setFamily_members (List<family_member> family_members)
    {
        this.family_members = family_members;
    }

    public void addFamily_member(family_member family_member) {
        family_members.add(family_member);
        if (!family_member.getRevenues().contains(this)) {
            family_member.addRevenues(this);
        }
    }

    public List<family_member> getFamily_members(){return this.family_members;}


    public source_revenue getSource_revenue() {
        return source_revenue;
    }
    public void setSource_revenue(source_revenue source_revenue) {
        this.source_revenue = source_revenue;
        if(!source_revenue.getRevenues().contains(this)){
            source_revenue.setRevenues(this);
        }
    }
}
