package ec.com.dinersclub.dddmodules.application.validate;

import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PartyAuthenticationAssessmentRequestValidator implements ConstraintValidator<ValidPartyAuthenticationAssessmentRequest, RecEvaluatePartyAuthenticationAssessmentRq> {

    @Override
    public boolean isValid(RecEvaluatePartyAuthenticationAssessmentRq request, ConstraintValidatorContext context) {
        if (request == null) {
            return false;
        }
       
        if((request.getPartyAuthenticationAssessment() == null || request.getPartyAuthenticationAssessment().getPartyReference() == null|| 
        	  request.getPartyAuthenticationAssessment().getPartyReference().getPartyType() == null ) ||  
        	  request.getPartyAuthenticationAssessment().getPartyReference().getPartyType().trim().isEmpty()) {
              addConstraintViolation(context, "El PartyReference es requerido");
              return false;
        }
        
         
        if((request.getPartyAuthenticationAssessment() == null || request.getPartyAuthenticationAssessment().getPartyReference() == null|| 
              request.getPartyAuthenticationAssessment().getPartyReference().getIdentifications().get(0) == null  || 
              request.getPartyAuthenticationAssessment().getPartyReference().getIdentifications().get(0).getIdentifier() == null || 
              request.getPartyAuthenticationAssessment().getPartyReference().getIdentifications().get(0).getIdentifier().getIdentifierValue() == null ) ||  
          	  request.getPartyAuthenticationAssessment().getPartyReference().getIdentifications().get(0).getIdentifier().getIdentifierValue().trim().isEmpty()) {
              addConstraintViolation(context, "El IdentifierValue es requerido");
              return false;
        }
        
        if(request.getPartyAuthenticationAssessment() == null || request.getPartyAuthenticationAssessment().getAuthenticationType() == null|| 
          	  request.getPartyAuthenticationAssessment().getAuthenticationType().trim().isEmpty()) {
              addConstraintViolation(context, "El AuthenticationType() es requerido");
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