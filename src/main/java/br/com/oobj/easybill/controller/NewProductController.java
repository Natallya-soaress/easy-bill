package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.NewProductRequisition;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.validator.PromotionalPriceValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/product")
public class NewProductController {

    private ProductRepository productRepository;
    private PromotionalPriceValidator promotionalPriceValidator;

    public NewProductController(ProductRepository productRepository, PromotionalPriceValidator promotionalPriceValidator){
        this.productRepository = productRepository;
        this.promotionalPriceValidator = promotionalPriceValidator;
    }

    @GetMapping("form")
    public String form(NewProductRequisition requisition){
        return "newProductForm";
    }

    @PostMapping("products")
    public String newProduct(@Valid NewProductRequisition requisition, BindingResult result){
        promotionalPriceValidator.valid(requisition, result);
        if(result.hasErrors()){
            return "newProductForm";
        }
        Product product = requisition.toProduct();
        productRepository.save(product);
        return "redirect:/admin/product/form";
    }

}
