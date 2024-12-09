package ec.com.dinersclub.dddmodules.domain.repository;

public interface PasswordInstanceRecordCommanRepository {
	<T> T  sendNotification(String url, T request);
}
