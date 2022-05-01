package com.ulstu.HomeBudget.Model;

import javax.persistence.*;
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
}
