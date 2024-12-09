package ec.com.dinersclub.dddmodules.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.dinersclub.dddmodules.application.validate.ValidTokenHeaders;
import ec.com.dinersclub.dddmodules.application.validate.ValidTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;
import ec.com.dinersclub.dddmodules.services.TokenOtpCreateUseCase;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/v1/token")
public class TokenOtpController {

	private static final Logger log = LoggerFactory.getLogger(TokenOtpController.class.getName());

	@Autowired	
	TokenOtpCreateUseCase tokenOtpCreateUseCase;
	
	 @PostMapping("/evaluate")
	    public ResponseEntity<RecEvaluateTokenResponse> tokenOtpValidate(@Valid @ValidTokenRequest @RequestBody RecEvaluateTokenRequest request,
	    														   @Valid @ValidTokenHeaders @RequestHeader HttpHeaders headers) {
	        log.info("Recibiendo solicitud para validar OTP request REST: {}, headers:{}",request,headers);
	        return new ResponseEntity<>( tokenOtpCreateUseCase.tokenOtpValidate(request, headers),HttpStatus.OK);
	    }

}
