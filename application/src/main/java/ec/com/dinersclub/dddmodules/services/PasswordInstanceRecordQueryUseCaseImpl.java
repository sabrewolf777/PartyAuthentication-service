package ec.com.dinersclub.dddmodules.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import ec.com.dinersclub.dddmodules.domain.password.DinNotifRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs;
import ec.com.dinersclub.dddmodules.domain.repository.PasswordInstanceRecordCommanRepository;
import ec.com.dinersclub.dddmodules.infrastructure.outbound.mapper.MapperRecPassToDinNotif;

@Service
public class PasswordInstanceRecordQueryUseCaseImpl implements PasswordInstanceRecordQueryUseCase{
	
	@Autowired
	PasswordInstanceRecordCommanRepository passwordInstanceRecordCommanRepository;
	
	@Value("${msd.seg.aut.notif.postlogin}")
    String apiUrl;
	
	@Override
	public RecNotifyPasswordInstanceRecordRs sendNotification(RecNotifyPasswordInstanceRecordRq request,HttpHeaders headers) {
		
		final DinNotifRq rq = MapperRecPassToDinNotif.toDinNotfRq(request, headers);
		
		final Object response= passwordInstanceRecordCommanRepository.sendNotification(apiUrl,rq);

		return MapperRecPassToDinNotif.toRecPassRs(response);
	}

}
