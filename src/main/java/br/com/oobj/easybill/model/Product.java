package br.com.oobj.easybill.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String imageURL;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    private BigDecimal promotionalPrice;

    @Column(length = 10)
    private String taxClass;

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}