package com.testOTS.demo.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="invoice_type")
public class InvoiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="invoice_type_description")
    private String invoiceTypeDescription;

    @Column(name="type")
    private String type;

    public InvoiceType() {
    }

    public InvoiceType(String invoiceTypeDescription, String type) {
        this.invoiceTypeDescription = invoiceTypeDescription;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceTypeDescription() {
        return invoiceTypeDescription;
    }

    public void setInvoiceTypeDescription(String invoiceTypeDescription) {
        this.invoiceTypeDescription = invoiceTypeDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InvoiceType{" +
                "id=" + id +
                ", invoiceTypeDescription='" + invoiceTypeDescription + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
