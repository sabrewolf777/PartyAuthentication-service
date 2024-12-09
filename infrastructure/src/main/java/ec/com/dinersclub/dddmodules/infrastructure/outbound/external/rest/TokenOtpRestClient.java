package ec.com.dinersclub.dddmodules.infrastructure.outbound.external.rest;

import org.springframework.http.HttpHeaders;

import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;

public interface TokenOtpRestClient {
	public RecEvaluateTokenResponse tokenOtpValidate(RecEvaluateTokenRequest request, HttpHeaders headers);
}
