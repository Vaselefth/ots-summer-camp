package com.testOTS.demo.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_service")
public class ProductService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "price_perItem")
    private String pricePerItem;

    @Column(name = "discount")
    private String discount;

    @Column(name = "is_product")
    private boolean isProduct;

    @ManyToOne
    @JoinColumn(name = "vat_id", referencedColumnName  = "id")
    private Vat vat;

    public ProductService() {
    }

    public ProductService(String productDescription, String pricePerItem, String discount, boolean isProduct, Vat vat) {
        this.productDescription = productDescription;
        this.pricePerItem = pricePerItem;
        this.discount = discount;
        this.isProduct = isProduct;
        this.vat = vat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(String pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public boolean isProduct() {
        return isProduct;
    }

    public void setProduct(boolean product) {
        isProduct = product;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "id=" + id +
                ", productDescription='" + productDescription + '\'' +
                ", pricePerItem='" + pricePerItem + '\'' +
                ", discount='" + discount + '\'' +
                ", isProduct=" + isProduct +
                ", vat=" + vat +
                '}';
    }
}
