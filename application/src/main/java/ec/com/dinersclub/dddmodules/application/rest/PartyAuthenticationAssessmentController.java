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

import ec.com.dinersclub.dddmodules.application.validate.ValidPartyAuthenticationAssessmentHeaders;
import ec.com.dinersclub.dddmodules.application.validate.ValidPartyAuthenticationAssessmentRequest;
import ec.com.dinersclub.dddmodules.application.validate.ValidPartyAuthenticationAssessmentRetrieveRequest;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs;
import ec.com.dinersclub.dddmodules.domain.assessment.RecRetrievePartyAuthenticationAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecRetrievePartyAuthenticationAssessmentRs;
import ec.com.dinersclub.dddmodules.services.PartyAuthenticationAssessmentQueryUseCase;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/v1/partyAuthenticationAssessment")
public class PartyAuthenticationAssessmentController {
		
		private static final Logger log = LoggerFactory.getLogger(PartyAuthenticationAssessmentController.class);
					
		@Autowired
		PartyAuthenticationAssessmentQueryUseCase partyAuthenticationAssessmentQueryUseCase;
		
		@PostMapping("/evaluate")
	    public ResponseEntity<RecEvaluatePartyAuthenticationAssessmentRs> verifyDataClient(@Valid @ValidPartyAuthenticationAssessmentRequest @RequestBody RecEvaluatePartyAuthenticationAssessmentRq request,
	    														         				   @Valid @ValidPartyAuthenticationAssessmentHeaders @RequestHeader HttpHeaders headers) {
	        log.info("Request verifyDataClient: {}, headers:{}",request,headers);
	        
	        return new ResponseEntity<>( partyAuthenticationAssessmentQueryUseCase.verifyDataClient(request, headers),HttpStatus.OK);
	    }

		
		@PostMapping("/retrieve")
	    public ResponseEntity<RecRetrievePartyAuthenticationAssessmentRs> verifyProfile(@Valid @ValidPartyAuthenticationAssessmentRetrieveRequest @RequestBody RecRetrievePartyAuthenticationAssessmentRq request,
	    														         				@Valid @ValidPartyAuthenticationAssessmentHeaders @RequestHeader HttpHeaders headers) {
	        log.info("Request verifyDataClient: {}, headers:{}",request,headers);
	        
	        return new ResponseEntity<>( partyAuthenticationAssessmentQueryUseCase.verifyProfile(request, headers),HttpStatus.OK);
	    }

		
}	
