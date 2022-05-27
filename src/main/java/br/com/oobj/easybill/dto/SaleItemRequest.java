package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.model.Sale;
import br.com.oobj.easybill.model.SaleItem;
import br.com.oobj.easybill.repository.ProductRepository;

import javax.validation.constraints.*;

public class SaleItemRequest {

    @NotNull
    @Positive
    private int quantity;

    @Size(max = 500)
    private String note;

    @NotNull
    private Long productId;

    public SaleItemRequest() {
    }

    public SaleItemRequest(SaleItem saleItem) {
        this.quantity = saleItem.getQuantity();
        this.note = saleItem.getNote();
        this.productId = saleItem.getId();
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public SaleItem toSaleItem(Product product){

        SaleItem saleItem = new SaleItem();

        saleItem.setNote(note);
        saleItem.setPrice(product.getPrice());
        saleItem.setProduct(product);
        saleItem.setQuantity(quantity);

        return saleItem;
    }

    public SaleItem toSaleItem(ProductRepository productRepository, Sale sale){

        SaleItem saleItem = new SaleItem();

        saleItem.setNote(note);
        saleItem.setQuantity(quantity);
        saleItem.setSale(sale);

        saleItem.setProduct(productRepository.findById(productId).get());

        if(productRepository.findById(productId).get().getPromotionalPrice() == null){
            saleItem.setPrice(productRepository.findById(productId).get().getPrice());
        } else {
            saleItem.setPrice(productRepository.findById(productId).get().getPromotionalPrice());
        }

        return saleItem;
    }

}
