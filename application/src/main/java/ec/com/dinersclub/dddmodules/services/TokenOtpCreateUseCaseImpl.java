package ec.com.dinersclub.dddmodules.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;
import ec.com.dinersclub.dddmodules.domain.repository.TokenOtpCommandRepository;

@Service
public class TokenOtpCreateUseCaseImpl implements TokenOtpCreateUseCase {

	@Autowired
	TokenOtpCommandRepository tokenOtpCommandRepository;
	
	public RecEvaluateTokenResponse tokenOtpValidate(RecEvaluateTokenRequest request,HttpHeaders headers) {
		return tokenOtpCommandRepository.tokenOtpValidate(request, headers);
	}
}
