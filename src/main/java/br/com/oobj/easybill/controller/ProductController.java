package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.ProductRequest;
import br.com.oobj.easybill.model.Product;
import br.com.oobj.easybill.repository.ProductRepository;
import br.com.oobj.easybill.validator.PromotionalPriceValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class ProductController {

    private ProductRepository productRepository;
    private PromotionalPriceValidator promotionalPriceValidator;
    private ProductAPIController productAPIController;

    public ProductController(ProductRepository productRepository, PromotionalPriceValidator promotionalPriceValidator, ProductAPIController productAPIController){
        this.productRepository = productRepository;
        this.promotionalPriceValidator = promotionalPriceValidator;
        this.productAPIController = productAPIController;
    }

    @GetMapping("product/form")
    public String form(ProductRequest requisition){
        return "newProductForm";
    }

    @GetMapping("products")
    public ModelAndView showProducts(){
        ModelAndView modelAndView = new ModelAndView("showProductForm");
        modelAndView.addObject("product", productAPIController.showProducts());
        return modelAndView;
    }

    @PostMapping("/product/products")
    public String newProduct(@Valid ProductRequest requisition, BindingResult result){
        promotionalPriceValidator.valid(requisition, result);
        if(result.hasErrors()){
            return "newProductForm";
        }
        Product product = requisition.toProduct();
        productRepository.save(product);
        return "redirect:/admin/products";
    }
}