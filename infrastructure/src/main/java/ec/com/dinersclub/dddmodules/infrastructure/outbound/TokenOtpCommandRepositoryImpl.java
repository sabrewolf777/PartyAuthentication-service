package ec.com.dinersclub.dddmodules.infrastructure.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;

import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;
import ec.com.dinersclub.dddmodules.domain.repository.TokenOtpCommandRepository;
import ec.com.dinersclub.dddmodules.infrastructure.outbound.external.rest.TokenOtpRestClient;

@Repository
public class TokenOtpCommandRepositoryImpl implements TokenOtpCommandRepository {

	@Autowired
	TokenOtpRestClient tokenOtpRestClient;
	
	
	@Override
	public RecEvaluateTokenResponse tokenOtpValidate(RecEvaluateTokenRequest request, HttpHeaders headers) {
		return tokenOtpRestClient.tokenOtpValidate(request, headers);
	}

}
