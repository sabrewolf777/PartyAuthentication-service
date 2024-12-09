package ec.com.dinersclub.dddmodules.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import ec.com.dinersclub.dddmodules.application.validate.ValidTokenHeaders;
import ec.com.dinersclub.dddmodules.application.validate.ValidTokenRequest;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs;
import jakarta.validation.Valid;

public interface PartyAuthenticationAssessmentQueryUseCase {
	public RecEvaluatePartyAuthenticationAssessmentRs verifyDataClient(RecEvaluatePartyAuthenticationAssessmentRq request, HttpHeaders headers);
}	
