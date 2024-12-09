package ec.com.dinersclub.dddmodules.domain.repository;

public interface PartyAuthenticationAssessmentCommanRepository {
	<T> T  verifyDataClient(String url, T request);
}
