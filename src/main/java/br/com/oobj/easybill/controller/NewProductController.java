package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.NewProductRequisition;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.validator.PromotionalPriceValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
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

    @RequestMapping("new")
    public String newProduct(@Valid NewProductRequisition requisition, BindingResult result){
        if(result.hasErrors() || !promotionalPriceValidator.isValid(requisition)){
            return "newProductForm";
        }
        Product product = requisition.toProduct();
        productRepository.save(product);
        return "redirect:/product/form";
    }

}
