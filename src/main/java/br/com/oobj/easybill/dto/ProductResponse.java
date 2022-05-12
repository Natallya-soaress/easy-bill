package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal effectivePrice;
    private String taxClass;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.taxClass = product.getTaxClass();
        if(product.getPromotionalPrice() != null){
            this.effectivePrice = product.getPromotionalPrice();
        } else{
            this.effectivePrice = product.getPrice();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public BigDecimal getEffectivePrice() {
        return effectivePrice;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public static List<ProductResponse> toListProductResponse(List<Product> products) {
        return products.stream().map(ProductResponse::new).collect(Collectors.toList());
    }
}
