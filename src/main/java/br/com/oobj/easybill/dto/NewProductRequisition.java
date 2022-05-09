package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;

import java.math.BigDecimal;

public class NewProductRequisition {

    private String productName;
    private String imageUrl;
    private String descriptionProduct;
    private String priceProduct;
    private String promotionalPriceProduct;
    private String taxClass;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getPromotionalPriceProduct() {
        return promotionalPriceProduct;
    }

    public void setPromotionalPriceProduct(String promotionalPriceProduct) {
        this.promotionalPriceProduct = promotionalPriceProduct;
    }

    public Product toProduct() {
        Product product = new Product();

        product.setName(productName);
        product.setDescription(descriptionProduct);
        product.setImageURL(imageUrl);
        product.setPrice(new BigDecimal(priceProduct));
        product.setPromotionalPrice(new BigDecimal(promotionalPriceProduct));
        product.setTaxClass(taxClass);

        return product;
    }
}
