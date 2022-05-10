package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class NewProductRequisition {

    @NotBlank
    @Max(150)
    private String productName;

    @NotBlank
    @Max(500)
    private String imageUrl;

    @Max(1000)
    private String descriptionProduct;

    @NotBlank
    @DecimalMin("1")
    private String priceProduct;

    @DecimalMin("1")
    private String promotionalPriceProduct;

    @NotBlank
    @Length(min=10, max=10)
    @Pattern(regexp = "^[0-9]{4}[.][0-9]{2}[.][0-9]{2}+$")
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

    public String promotionalPrice(){
        return  (String) getPromotionalPriceProduct();
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
