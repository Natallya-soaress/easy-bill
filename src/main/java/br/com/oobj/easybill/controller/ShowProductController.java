package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.NewProductRequisition;
import br.com.oobj.easybill.dto.ProductResponse;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.validator.PromotionalPriceValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("api")
@RestController
public class ShowProductController {

    private ProductRepository productRepository;
    private PromotionalPriceValidator promotionalPriceValidator;

    public ShowProductController(ProductRepository productRepository, PromotionalPriceValidator promotionalPriceValidator){
        this.productRepository = productRepository;
        this.promotionalPriceValidator = promotionalPriceValidator;
    }

    @GetMapping("/products")
    public List<ProductResponse> showProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productsResponse = ProductResponse.toListProductResponse(products);
        return productsResponse;
    }

    @PostMapping("/admin/products")
    public ResponseEntity<NewProductRequisition> newProduct(@RequestBody @Valid NewProductRequisition requisition, UriComponentsBuilder uriBuilder, BindingResult result) {
        promotionalPriceValidator.valid(requisition, result);
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(new NewProductRequisition());
        } else {
            Product product = requisition.toProduct();
            productRepository.save(product);

            URI uri = uriBuilder.path("products/{id}").buildAndExpand(product.getId()).toUri();

            return ResponseEntity.created(uri).body(new NewProductRequisition(product));
        }
    }

}
