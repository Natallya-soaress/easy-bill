package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.model.SaleItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SaleItemResponse {

    private int quantity;
    private String note;
    private BigDecimal price;
    private BigDecimal promotionalPrice;
    private Sale sale;
    private Product product;

    public SaleItemResponse(SaleItem saleItem) {
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

    public static List<SaleItemResponse> toListSaleItemResponse(List<SaleItem> salesItems) {
        return salesItems.stream().map(SaleItemResponse::new).collect(Collectors.toList());
    }
}
