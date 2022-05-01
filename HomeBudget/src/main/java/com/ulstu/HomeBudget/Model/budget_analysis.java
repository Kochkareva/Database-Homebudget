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
public class budget_analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    int now_month;
    int revenue_month;
    int expenses_month;
    int surplus;
    int plan_expenses;
    int plan_revenue;
    int discrepancy_expenses;
    int discrepancy_revenue;
    int reserve;

    public budget_analysis(int now_month, int revenue_month, int expenses_month, int surplus,
                           int plan_expenses, int plan_revenue, int discrepancy_expenses, int discrepancy_revenue, int reserve){
        this.now_month = now_month;
        this.revenue_month = revenue_month;
        this.expenses_month = expenses_month;
        this.surplus = surplus;
        this.plan_expenses=plan_expenses;
        this.plan_revenue = plan_revenue;
        this.discrepancy_expenses = discrepancy_expenses;
        this.discrepancy_revenue = discrepancy_revenue;
        this.reserve = reserve;
    }

    public Long getId() { return id;}

    public int getNow_month(){return now_month;}
    public void setNow_month(int now_month){this.now_month = now_month;}

    public int getRevenue_month(){return revenue_month;}
    public void setRevenue_month(int revenue_month){this.revenue_month = revenue_month;}

    public int getExpenses_month(){return expenses_month;}
    public void setExpenses_month(int expenses_month){this.expenses_month = expenses_month;}

    public int getSurplus(){return surplus;}
    public void setSurplus(int surplus){this.surplus = surplus;}

    public int getPlan_expenses(){return plan_expenses;}
    public void setPlan_expenses(int plan_expenses){this.plan_expenses=plan_expenses;}

    public int getPlan_revenue(){return plan_revenue;}
    public void setPlan_revenue(int plan_revenue){this.plan_revenue=plan_revenue;}

    public int getDiscrepancy_expenses(){return discrepancy_expenses;}
    public void setDiscrepancy_expenses(int plan_expenses){this.plan_expenses = plan_expenses; }

    public int getDiscrepancy_revenue(){return discrepancy_revenue;}
    public void setDiscrepancy_revenue(int discrepancy_revenue){this.discrepancy_revenue=discrepancy_revenue;}

    public int getReserve(){return reserve;}
    public void setReserve(int reserve){this.reserve=reserve;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "budget_analysis{" +
                "id = " + id +
                ", now_month = '" + now_month + '\'' +
                ", revenue_month = '" + revenue_month + '\'' +
                ", expenses_month = '" + expenses_month + '\'' +
                ", surplus = '" + surplus + '\'' +
                ", plan_expenses = '" + plan_expenses + '\'' +
                ", plan_revenue = '" + plan_revenue + '\'' +
                ", discrepancy_expenses = '" + discrepancy_expenses + '\'' +
                ", discrepancy_revenue = '" + discrepancy_revenue + '\'' +
                ", reserve = '" + reserve + '\'' +
                '}';
    }
}
