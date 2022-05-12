package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.ProductResponse;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api")
@RestController
public class ShowProductController {

    private ProductRepository productRepository;

    public ShowProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductResponse> showProducts(){
        List<Product> products = productRepository.findAll();
        return ProductResponse.toListProductResponse(products);
    }

}
