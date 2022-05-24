package br.com.oobj.easybill.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_items")
public class SaleItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private String note;
    private BigDecimal price;
    private BigDecimal promotionalPrice;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
