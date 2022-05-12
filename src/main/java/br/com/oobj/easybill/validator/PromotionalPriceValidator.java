package br.com.oobj.easybill.validator;

import br.com.oobj.easybill.dto.NewProductRequisition;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PromotionalPriceValidator implements ConstraintValidator<PromotionalPriceConstraint, NewProductRequisition> {

    @Override
    public void initialize(PromotionalPriceConstraint promotionalPriceConstraint){

    }

    @Override
    public boolean isValid(NewProductRequisition requisition, ConstraintValidatorContext constraintValidatorContext) {
        Integer compare = requisition.getPriceProduct().compareTo(requisition.getPromotionalPriceProduct());
        if(compare.equals(1)){
            return true;
        } else{
            return false;
        }
    }
}
