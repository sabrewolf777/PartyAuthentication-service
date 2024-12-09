package ec.com.dinersclub.dddmodules.infrastructure.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.com.dinersclub.dddmodules.domain.repository.PartyAuthenticationAssessmentCommanRepository;
import ec.com.dinersclub.dddmodules.infrastructure.outbound.external.rest.ExternalServicePort;

@Repository
public class PartyAuthenticationAssessmentCommandRepositoryImpl implements PartyAuthenticationAssessmentCommanRepository{

	@Autowired
	ExternalServicePort externalServicePort;
	
	@Override
	public <T> T verifyDataClient(String url, T request) {
		return (T) externalServicePort.sendDataToExternalService(url, request);
	}

}
