package br.com.oobj.easybill.validator;

import br.com.oobj.easybill.dto.ProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static java.util.Objects.isNull;

@Component
public class PromotionalPriceValidator {

    public void valid(ProductRequest requisition, BindingResult result){
        if(isNull(requisition.getPriceProduct())){
            return;
        }
        if(isNull(requisition.getPromotionalPriceProduct())){
            return;
        }
        Integer compare = requisition.getPriceProduct().compareTo(requisition.getPromotionalPriceProduct());
        if(compare.equals(1)){
            return;
        }
        result.rejectValue("promotionalPriceProduct", "", "Promotional price must be less than the effective price!!");
    }

}
