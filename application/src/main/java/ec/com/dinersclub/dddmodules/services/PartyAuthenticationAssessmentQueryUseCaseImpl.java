package ec.com.dinersclub.dddmodules.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import ec.com.dinersclub.dddmodules.domain.assessment.DinAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs;
import ec.com.dinersclub.dddmodules.domain.repository.PartyAuthenticationAssessmentCommanRepository;
import ec.com.dinersclub.dddmodules.infrastructure.outbound.mapper.MapperRecEvaPartyAssToDinAssessment;

@Service
public class PartyAuthenticationAssessmentQueryUseCaseImpl implements PartyAuthenticationAssessmentQueryUseCase{

	@Autowired
	PartyAuthenticationAssessmentCommanRepository partyAuthenticationAssessmentCommanRepository;
	
	@Value("${msd.seg.cli.verificacion.datos}")
    String apiUrl;
	
	@Override
	public RecEvaluatePartyAuthenticationAssessmentRs verifyDataClient(RecEvaluatePartyAuthenticationAssessmentRq request, HttpHeaders headers) {
		
		final DinAssessmentRq rq=MapperRecEvaPartyAssToDinAssessment.toDinAssessment(request, headers);
		
		final Object resp=partyAuthenticationAssessmentCommanRepository.verifyDataClient(apiUrl,rq);
		
		return MapperRecEvaPartyAssToDinAssessment.toRecEvaPartyAut(resp);
	}

}