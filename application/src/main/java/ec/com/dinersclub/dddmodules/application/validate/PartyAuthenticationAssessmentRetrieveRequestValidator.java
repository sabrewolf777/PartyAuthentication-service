package ec.com.dinersclub.dddmodules.application.validate;

import ec.com.dinersclub.dddmodules.domain.assessment.RecRetrievePartyAuthenticationAssessmentRq;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PartyAuthenticationAssessmentRetrieveRequestValidator implements ConstraintValidator<ValidPartyAuthenticationAssessmentRetrieveRequest, RecRetrievePartyAuthenticationAssessmentRq> {

    @Override
    public boolean isValid(RecRetrievePartyAuthenticationAssessmentRq
    		request, ConstraintValidatorContext context) {
        if (request == null) {
            return false;
        }
        
        if(request.getOperationType() == null ||  request.getOperationType().trim().isEmpty()) {
            addConstraintViolation(context, "El OperationType es requerido");
            return false;
        }
              
        return true;
    }
    
    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
               .addConstraintViolation();
    }
}