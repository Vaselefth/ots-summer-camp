package com.testOTS.demo.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="price_per_item")
    private double pricePerItem;

    @Column(name="discount")
    private double discount;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price_prior_vat")
    private double pricePriorVat;

    @Column(name="total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName  = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName  = "id")
    private ProductService productService;

    @ManyToOne
    @JoinColumn(name = "vat_id", referencedColumnName  = "id")
    private Vat vat;

    public InvoiceDetail() {
    }

    public InvoiceDetail(double pricePerItem, double discount, int quantity, double pricePriorVat, double totalPrice, Invoice invoice, ProductService productService, Vat vat) {
        this.pricePerItem = pricePerItem;
        this.discount = discount;
        this.quantity = quantity;
        this.pricePriorVat = pricePriorVat;
        this.totalPrice = totalPrice;
        this.invoice = invoice;
        this.productService = productService;
        this.vat = vat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePriorVat() {
        return pricePriorVat;
    }

    public void setPricePriorVat(double pricePriorVat) {
        this.pricePriorVat = pricePriorVat;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", pricePerItem=" + pricePerItem +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", pricePriorVat=" + pricePriorVat +
                ", totalPrice=" + totalPrice +
                ", invoice=" + invoice +
                ", productService=" + productService +
                ", vat=" + vat +
                '}';
    }
}
