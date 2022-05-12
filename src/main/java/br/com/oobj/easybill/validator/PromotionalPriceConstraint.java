package br.com.oobj.easybill.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PromotionalPriceValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface PromotionalPriceConstraint {

    String message() default "Invalid promotional price!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
