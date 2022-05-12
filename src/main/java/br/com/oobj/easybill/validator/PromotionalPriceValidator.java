package br.com.oobj.easybill.validator;

import br.com.oobj.easybill.dto.NewProductRequisition;
import org.springframework.stereotype.Component;

@Component
public class PromotionalPriceValidator {

    public boolean isValid(NewProductRequisition requisition){
        Integer compare = requisition.getPriceProduct().compareTo(requisition.getPromotionalPriceProduct());
        if(compare.equals(1)){
            return true;
        } else{
            return false;
        }
    }

}
