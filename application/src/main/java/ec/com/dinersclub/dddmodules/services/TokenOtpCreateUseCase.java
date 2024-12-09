package ec.com.dinersclub.dddmodules.services;

import org.springframework.http.HttpHeaders;

import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;

public interface TokenOtpCreateUseCase {
	public RecEvaluateTokenResponse tokenOtpValidate(RecEvaluateTokenRequest request,HttpHeaders headers);

}
