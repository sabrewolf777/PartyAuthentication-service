package ec.com.dinersclub.dddmodules.services;

import org.springframework.http.HttpHeaders;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs;

public interface PasswordInstanceRecordQueryUseCase {
	public RecNotifyPasswordInstanceRecordRs sendNotification(RecNotifyPasswordInstanceRecordRq request, HttpHeaders headers);
}
