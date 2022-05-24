package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.model.SaleItem;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class SaleItemRequest {

    @NotNull
    @Positive
    private int quantity;

    @Size(max = 500)
    private String note;

    @NotNull
    @Min(1)
    private BigDecimal price;

    @Min(1)
    private BigDecimal promotionalPrice;

    @NotBlank
    private Sale sale;

    @NotBlank
    private Product product;

    public SaleItemRequest() {
    }

    public SaleItemRequest(SaleItem saleItem) {
        this.note = saleItem.getNote();
        this.price = saleItem.getPrice();
        this.promotionalPrice = saleItem.getPromotionalPrice();
        this.sale = saleItem.getSale();
        this.product = saleItem.getProduct();
        this.quantity = saleItem.getQuantity();
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

    public SaleItem toSaleItem(){
        SaleItem saleItem = new SaleItem();

        saleItem.setSale(sale);
        saleItem.setNote(note);
        saleItem.setPrice(price);
        saleItem.setProduct(product);
        saleItem.setQuantity(quantity);
        saleItem.setPromotionalPrice(promotionalPrice);

        return saleItem;
    }
}
