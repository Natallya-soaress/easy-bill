package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductRequest {

    @NotBlank
    @Size(max=150)
    private String productName;

    @NotBlank
    @Size(max=500)
    private String imageUrl;

    @Size(max=1000)
    private String descriptionProduct;

    @NotNull
    @Min(1)
    private BigDecimal priceProduct;

    @Min(1)
    private BigDecimal promotionalPriceProduct;

    @NotBlank
    @Length(min=10, max=10)
    @Pattern(regexp = "^[0-9]{4}[.][0-9]{2}[.][0-9]{2}+$")
    private String taxClass;

    public ProductRequest() {
    }

    public ProductRequest(Product product) {
        this.productName = product.getName();
        this.priceProduct = product.getPrice();
        this.descriptionProduct = product.getDescription();
        this.imageUrl = product.getImageURL();
        this.promotionalPriceProduct = product.getPromotionalPrice();
        this.taxClass = product.getTaxClass();
    }

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

    public BigDecimal getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(BigDecimal priceProduct) {
        this.priceProduct = priceProduct;
    }

    public BigDecimal getPromotionalPriceProduct() {
        return promotionalPriceProduct;
    }

    public void setPromotionalPriceProduct(BigDecimal promotionalPriceProduct) {
        this.promotionalPriceProduct = promotionalPriceProduct;
    }

    public Product toProduct() {
        Product product = new Product();

        product.setName(productName);
        product.setDescription(descriptionProduct);
        product.setImageURL(imageUrl);
        product.setPrice(priceProduct);
        product.setPromotionalPrice(promotionalPriceProduct);
        product.setTaxClass(taxClass);

        return product;
    }

    public Product update(Long id, ProductRepository productRepository){
        Product product = productRepository.getById(id);

        product.setName(this.productName);
        product.setDescription(descriptionProduct);
        product.setImageURL(imageUrl);
        product.setPrice(priceProduct);
        product.setPromotionalPrice(promotionalPriceProduct);
        product.setTaxClass(taxClass);

        return product;
    }
}
