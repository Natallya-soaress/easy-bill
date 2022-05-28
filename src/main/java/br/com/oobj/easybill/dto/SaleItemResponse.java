package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.SaleItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleItemResponse {

    private Long id;
    private int quantity;
    private String note;
    private BigDecimal price;
    private Long productId;

    public SaleItemResponse() {
    }

    public SaleItemResponse(SaleItem saleItem) {
        this.id = saleItem.getId();
        this.note = saleItem.getNote();
        this.price = saleItem.getPrice();
        this.quantity = saleItem.getQuantity();
        this.productId = saleItem.getProduct().getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public SaleItemResponse toSaleItemResponse(SaleItem saleItem){

        SaleItemResponse saleItemResponse = new SaleItemResponse();

        saleItemResponse.setId(id);
        saleItemResponse.setNote(note);
        saleItemResponse.setPrice(saleItem.getPrice());
        saleItemResponse.setQuantity(quantity);
        saleItemResponse.setProductId(productId);

        return saleItemResponse;
    }

    public static List<SaleItemResponse> toListSaleItemResponse(List<SaleItem> salesItems) {
        List<SaleItemResponse> itemsResponse = new ArrayList<>();
        salesItems.forEach(item -> {
            SaleItemResponse saleItemResponse = new SaleItemResponse(item);
            itemsResponse.add(saleItemResponse);
        });
        return itemsResponse;
    }
}
