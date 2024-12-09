package ec.com.dinersclub.dddmodules.application.validate;

import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRq;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordInstanceRecordRequestValidator implements ConstraintValidator<ValidPasswordInstanceRecordRequest, RecNotifyPasswordInstanceRecordRq> {

    @Override
    public boolean isValid(RecNotifyPasswordInstanceRecordRq request, ConstraintValidatorContext context) {
        
    	if (request == null) {
            return false;
        }
         	  
        if(request.getUsername() == null ||  request.getUsername().trim().isEmpty()) {
            addConstraintViolation(context, "El Username es requerido");
            return false;
        }
    	
        if(request.getPasswordInstanceRecord() == null || request.getPasswordInstanceRecord().getAuthenticationPasswordTestResult() == null|| 
        	  request.getPasswordInstanceRecord().getAuthenticationPasswordTestResult().trim().isEmpty()) {
              addConstraintViolation(context, "El AuthenticationPasswordTestResult es requerido");
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