package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.NewProductRequisition;
import br.com.oobj.easybill.dto.ProductResponse;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.validator.PromotionalPriceValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("api")
@RestController
public class ProductAPIController {

    private ProductRepository productRepository;
    private PromotionalPriceValidator promotionalPriceValidator;

    public ProductAPIController(ProductRepository productRepository, PromotionalPriceValidator promotionalPriceValidator){
        this.productRepository = productRepository;
        this.promotionalPriceValidator = promotionalPriceValidator;
    }

    @GetMapping("/products")
    public  List<ProductResponse> showProducts(){
        List<Product> products = productRepository.findAll();
        return ProductResponse.toListProductResponse(products);
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

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> detail(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(new ProductResponse(product.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/admin/products/{id}")
    @Transactional
    public ResponseEntity<NewProductRequisition> update(@PathVariable Long id, @Valid @RequestBody NewProductRequisition requisition){
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product product = requisition.update(id, productRepository);
            return ResponseEntity.ok(new NewProductRequisition(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admin/products/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
