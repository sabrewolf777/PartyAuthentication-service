package ec.com.dinersclub.dddmodules.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.com.dinersclub.dddmodules.application.validate.ValidPasswordInstanceRecordRequest;
import ec.com.dinersclub.dddmodules.application.validate.ValidTokenHeaders;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRq;
import ec.com.dinersclub.dddmodules.domain.password.RecNotifyPasswordInstanceRecordRs;
import ec.com.dinersclub.dddmodules.services.PasswordInstanceRecordQueryUseCase;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/v1/passwordInstanceRecord")
public class PasswordInstanceRecordController {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordInstanceRecordController.class);

	@Autowired
	PasswordInstanceRecordQueryUseCase passwordInstanceRecordQueryUseCase;
	
	
	@PostMapping("/notify")
    public ResponseEntity<RecNotifyPasswordInstanceRecordRs> sendNotification(@Valid @ValidPasswordInstanceRecordRequest @RequestBody RecNotifyPasswordInstanceRecordRq request,
    														         	      @Valid @ValidTokenHeaders @RequestHeader HttpHeaders headers) {
        log.info("Request sendNotification: {}, headers:{}",request,headers);
        
        return new ResponseEntity<>( passwordInstanceRecordQueryUseCase.sendNotification(request, headers),HttpStatus.OK);
    }
}
