package ec.com.dinersclub.dddmodules.infrastructure.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ec.com.dinersclub.dddmodules.domain.repository.PasswordInstanceRecordCommanRepository;
import ec.com.dinersclub.dddmodules.infrastructure.outbound.external.rest.ExternalServicePort;

@Repository
public class PasswordInstanceRecordCommandRepositoryImpl implements PasswordInstanceRecordCommanRepository{

	@Autowired
	ExternalServicePort externalServicePort;
	
	@Override
	public <T> T sendNotification(String url, T request) {
		return externalServicePort.sendDataToExternalService(url, request);
	}

}
