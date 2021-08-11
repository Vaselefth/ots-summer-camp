package com.testOTS.demo.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="invoice_description")
    private String invoiceDescription;

    @Column(name="total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name="invoice_type_id", referencedColumnName = "id")
    private InvoiceType invoiceType;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="transactor_id", referencedColumnName = "id")
    private Transactor transactor;

    @OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;

    public Invoice(Date dateCreated, String invoiceDescription, double totalAmount, InvoiceType invoiceType, User user, Transactor transactor, List<InvoiceDetail> invoiceDetails) {
        this.dateCreated = dateCreated;
        this.invoiceDescription = invoiceDescription;
        this.totalAmount = totalAmount;
        this.invoiceType = invoiceType;
        this.user = user;
        this.transactor = transactor;
        this.invoiceDetails = invoiceDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    public void setInvoiceDescription(String invoiceDescription) {
        this.invoiceDescription = invoiceDescription;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transactor getTransactor() {
        return transactor;
    }

    public void setTransactor(Transactor transactor) {
        this.transactor = transactor;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", invoiceDescription='" + invoiceDescription + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoiceType=" + invoiceType +
                ", user=" + user +
                ", transactor=" + transactor +
                ", invoiceDetails=" + invoiceDetails +
                '}';
    }
}
