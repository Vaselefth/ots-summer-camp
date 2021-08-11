package com.testOTS.demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vat")
public class Vat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="vat_value")
    private double vatValue;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name="valid_date")
    private Date validDate;

    @Column(name="vat_description")
    private String vatDescription;

    public Vat() {
    }

    public Vat(double vatValue, Date validDate, String vatDescription) {
        this.vatValue = vatValue;
        this.validDate = validDate;
        this.vatDescription = vatDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getVatValue() {
        return vatValue;
    }

    public void setVatValue(double vatValue) {
        this.vatValue = vatValue;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getVatDescription() {
        return vatDescription;
    }

    public void setVatDescription(String vatDescription) {
        this.vatDescription = vatDescription;
    }

    @Override
    public String toString() {
        return "Vat{" +
                "id=" + id +
                ", vatValue=" + vatValue +
                ", validDate=" + validDate +
                ", vatDescription='" + vatDescription + '\'' +
                '}';
    }
}
