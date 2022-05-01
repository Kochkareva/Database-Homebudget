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
public class source_revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column()
    String name_source;
    String type_source;
    String regularity;
    String nature_receipt;
    String real_form;

    public source_revenue(String name_source, String type_source, String regularity, String nature_receipt, String real_form){
        this.name_source = name_source;
        this.type_source = type_source;
        this.regularity = regularity;
        this.nature_receipt = nature_receipt;
        this.real_form = real_form;
    }

    public Long getId() { return id;}

    public String getName_source(){return name_source;}
    public void setName_source(String name_source){this.name_source = name_source;}

    public String getType_source(){return type_source;}
    public void setType_source(String type_source){this.type_source = type_source;}

    public String getRegularity(){return regularity;}
    public void setRegularity(String regularity){this.regularity = regularity;}

    public String getNature_receipt(){return nature_receipt;}
    public void setNature_receipt(String nature_receipt){this.nature_receipt = nature_receipt;}

    public String getReal_form(){return real_form;}
    public void setReal_form(String real_form){this.real_form = real_form;}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "source_revenue{" +
                "id = " + id +
                ", name_source = '" + name_source + '\'' +
                ", type_source = '" + type_source + '\'' +
                ", regularity = '" + regularity + '\'' +
                ", nature_receipt = '" + nature_receipt + '\'' +
                ", real_form = '" + real_form + '\'' +
                '}';
    }
}
