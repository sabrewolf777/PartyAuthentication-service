package ec.com.dinersclub.dddmodules.infrastructure.outbound.mapper;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import ec.com.dinersclub.dddmodules.domain.password.DinBodyNotifRq;
import ec.com.dinersclub.dddmodules.domain.password.DinNotifRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs.PasswordInstanceRecord;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs.PasswordInstanceRecord.UsageLog;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs.PasswordInstanceRecord.UsageLog.LogEntry;

public class MapperRecPassToDinNotif {

	private static final Logger log = LoggerFactory.getLogger(MapperRecPassToDinNotif.class);

	private MapperRecPassToDinNotif() {}

	
	public static DinNotifRq toDinNotfRq(RecNotifyPasswordInstanceRecordRq request,HttpHeaders headers) {
		
		
		
		return DinNotifRq.builder()
					.dinHeader(MapperDinHeader.mapperHeaderToDinnerHeader(headers))
					.dinBody(DinBodyNotifRq.builder()
											.usuario(request.getUsername())
											.resultado(request.getPasswordInstanceRecord().getAuthenticationPasswordTestResult())
											.build())
					
					.build();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static RecNotifyPasswordInstanceRecordRs toRecPassRs(Object resp) {
		
		final LinkedHashMap<String, Map<String,String>> map=(LinkedHashMap<String, Map<String,String>>) resp;
		RecNotifyPasswordInstanceRecordRs response = new RecNotifyPasswordInstanceRecordRs();
		
		map.forEach((k,v) ->{
			log.info("key: {}, value: {}",k,v);
			if(k.equals("dinBody")) {
				
				response.setPasswordInstanceRecord(PasswordInstanceRecord.builder()
						
													.usageLog(UsageLog.builder()
																		.logEntry(LogEntry.builder()
																							.logEntryValueDate(v.get("fecha"))
																							.logEntryValueTime(v.get("hora"))
																							.build())
																		.build())
													.build());
				
				
			}else if(k.equals("dinError")) {
				response.setStatusInstanceRecord(ec.com.dinersclub.dddmodules.domain.password.
												 RecNotifyPasswordInstanceRecordRs.StatusInstanceRecord
												 .builder()
									     .statusType(v.get("tipo"))
									     .transactionDate(v.get("fecha"))
									     .status(v.get("origen"))
									     .statusCode(v.get("codigo"))
									     .providerCode(v.get("codigoErrorProveedor"))
									     .message(v.get("mensaje"))
									     .description(v.get("detalle"))		
						.build());
			}
			
			
			
		});
		
		return response;
	}
	
}
