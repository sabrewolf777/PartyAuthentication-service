package ec.com.dinersclub.dddmodules.application.grpc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenResponse;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest.Organisation;
import ec.com.dinersclub.dddmodules.domain.model.token.RecEvaluateTokenRequest.OrganisationIdentification;
import ec.com.dinersclub.dddmodules.domain.model.token.stubs.RecEvaluateTokenRq;
import ec.com.dinersclub.dddmodules.domain.model.token.stubs.RecEvaluateTokenRs;
import ec.com.dinersclub.dddmodules.domain.model.token.stubs.StatusInstanceRecord;
import ec.com.dinersclub.dddmodules.domain.model.token.stubs.TokenAssignmentRs;
import ec.com.dinersclub.dddmodules.domain.model.token.stubs.TokenOtpServiceGrpc.TokenOtpServiceImplBase;
import ec.com.dinersclub.dddmodules.services.TokenOtpCreateUseCase;
import io.grpc.Metadata;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TokenOtpGrpcController extends TokenOtpServiceImplBase{

	private static final Logger log = LoggerFactory.getLogger(TokenOtpGrpcController.class.getName());
	
	@Autowired	
	TokenOtpCreateUseCase tokenOtpCreateUseCase;
	
	private Metadata requestHeaders;
	
    public void validaTokenOtp(RecEvaluateTokenRq request, StreamObserver<RecEvaluateTokenRs> responseObserver) {
    	
    	log.info("Request Grpc: {}",request);
    	
     	requestHeaders = (Metadata) StoreServer.HEADERS.get();
     	
    	HttpHeaders headers =getHeaders();
    	
    	RecEvaluateTokenResponse res=tokenOtpCreateUseCase.tokenOtpValidate(null, headers);
    	
        RecEvaluateTokenRs response = RecEvaluateTokenRs.newBuilder()
                .setTokenAssignment(TokenAssignmentRs.newBuilder().build())
                .setStatusInstanceRecord(StatusInstanceRecord.newBuilder().build())
                .build();
        log.info("Response Grpc: {}",response);
        // Enviar la respuesta
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    private HttpHeaders getHeaders() {	
    	HttpHeaders headers= new HttpHeaders();
    	headers.add("applicationId", getHeader("applicationId"));
    	headers.add("sesionId", getHeader("sesionId"));
    	headers.add("channelId", getHeader("channelId"));
    	headers.add("device", getHeader("device"));
    	headers.add("portalId", getHeader("portalId"));
    	headers.add("uuid", getHeader("uuid"));
    	headers.add("ipaddress", getHeader("ipaddress"));
    	headers.add("transactionDate", getHeader("transactionDate"));
    	headers.add("simetricKey", getHeader("simetricKey"));
    	headers.add("userId", getHeader("userId"));
    	headers.add("recordsAmount", getHeader("recordsAmount"));
    	headers.add("pagesAmount", getHeader("pagesAmount"));
    	headers.add("pagesCurrentIndex", getHeader("pagesCurrentIndex"));
    	headers.add("pagsKeyValue", getHeader("pagsKeyValue"));   	
    	return headers;
    }
    
    
    public RecEvaluateTokenRequest grpcReqToPartyReq(RecEvaluateTokenRq request) {
    
    	List<OrganisationIdentification> listOrg= new ArrayList<>();
    	
    	OrganisationIdentification.builder()
								  	
								  .build();	
    	
    	return RecEvaluateTokenRequest.builder()
    			.organisation(Organisation.builder()
    						.organisationIdentification(null)
    						.build())
    			.build();
    }
    
    
    
    private String getHeader(String key) {
        Metadata.Key<String> metadataKey = Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER);
        return requestHeaders.get(metadataKey);
    }
    
    public String getValueAsString(String value) {
        final String valueReturn = value;
        if(valueReturn != null) {
        	 return valueReturn;
        }
        return "";
    }
}
