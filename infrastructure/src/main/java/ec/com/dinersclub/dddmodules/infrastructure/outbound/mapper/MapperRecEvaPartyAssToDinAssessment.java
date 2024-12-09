package ec.com.dinersclub.dddmodules.infrastructure.outbound.mapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import ec.com.dinersclub.dddmodules.domain.assessment.DinAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.DinBodyAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRq.PartyReference.ContactPoint;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.BiometricInstanceRecord;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.Identification;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.Identifier;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.IdentifierValue;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.PartyAuthenticationAssessment;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.PartyProfile;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.StatusInstanceRecord;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.TokenAssignment;
import ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.TokenIdentificationCode;

public class MapperRecEvaPartyAssToDinAssessment {
	
	private static final Logger log = LoggerFactory.getLogger(MapperRecEvaPartyAssToDinAssessment.class);

	private MapperRecEvaPartyAssToDinAssessment() {}
	
	@SuppressWarnings("unchecked")
	public static RecEvaluatePartyAuthenticationAssessmentRs toRecEvaPartyAut(Object resp) {
		
		final LinkedHashMap<String, Map<String,String>> map=(LinkedHashMap<String, Map<String,String>>) resp;
		RecEvaluatePartyAuthenticationAssessmentRs response = new RecEvaluatePartyAuthenticationAssessmentRs();
		
		List<Identification> identifications= new ArrayList<>(); 		
		
		
		
		map.forEach((k,v) ->{
			log.info("key: {}, value: {}",k,v);
			if(k.equals("dinBody")) {
				
				identifications.add(Identification.builder()
												  .personIdentificationType(Integer.parseInt(v.get("tipoIdentificacion")))
												  .identifier(Identifier.builder()
																	    .identifierValue(v.get("numeroIdentificacion"))
															  .build())
									.build());
				ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.ContactPoint contactCorreo= 
				new ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.ContactPoint();
				ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.ContactPoint contactEmail= 
				new ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.ContactPoint();
				
				if(v.get("correoOTP") != null) {
					contactCorreo.setContactPointValue(v.get("correoOTP"));
					contactCorreo.setContactPointType("Electronic Address");
				}if(v.get("celularOTP") != null) {
					contactEmail.setContactPointValue(v.get("celularOTP"));
					contactEmail.setContactPointType("Cellphone");
				}
				
				List<ec.com.dinersclub.dddmodules.domain.assessment.RecEvaluatePartyAuthenticationAssessmentRs.ContactPoint> contactPoints= new ArrayList<>();
				contactPoints.add(contactEmail);
				contactPoints.add(contactCorreo);
				
				response.setPartyAuthenticationAssessment(PartyAuthenticationAssessment.builder()
																	.authenticationDescription(v.get("descripcionValidación"))
																	.customerContactAuthenticationLevel(v.get("codigoValidacion"))
																	.partyReference(ec.com.dinersclub.dddmodules.domain.assessment.
																					RecEvaluatePartyAuthenticationAssessmentRs.PartyReference.builder()
																					.identifications(identifications)
																					.partyProfile(PartyProfile.builder()
																									.webSubsidiary(getBoolean(v.get("esAfiliadoWeb")))// valida si es esAfiliadoWeb o estaAfiliadoWeb este viene en el doc
																									.build())
																					.civilRegistryAvailability(getBoolean(v.get("registroCivilDisponible")))
																					.contactPoint(contactPoints)
																					.build())
																	.authenticationLockType(v.get("codigoBloqueo"))
																	.authenticationLockMinutes(getInt( v.get("minutosRestantes")))
																	.authenticationLockHours(getInt( v.get("horasRestantes")))
																	.authenticationMethod(v.get("tipoDigitos"))
																	.partyAuthenticationConsolidationRecord(getBoolean(v.get("resultadoOtrasValidaciones")))
																	.authenticationInput(getBoolean(v.get("reingreso")))
																	.authenticationLockSource(v.get("origenBloqueo"))
																
																	.build());
				response.setUsername(v.get("usuarioBiometrico"));
				response.setTokenAssignment(TokenAssignment.builder()
														   .tokenIdentificationCode(TokenIdentificationCode.builder()
																				.identifierValue(IdentifierValue.builder()
																								.value(v.get("token"))
																								.build())
																				.build())
											.build());
				
				response.setBiometricInstanceRecord(BiometricInstanceRecord.builder()
																			.authenticationBiometricFile(v.get("fotografia"))
																			.build());
				
				response.setMigrationType(v.get("fotografia"));
				
				
				
				
			}else if(k.equals("dinError")) {
				response.setStatusInstanceRecord(StatusInstanceRecord.builder()
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
	
	public static DinAssessmentRq toDinAssessment(RecEvaluatePartyAuthenticationAssessmentRq request,HttpHeaders headers) {
		
		return DinAssessmentRq.builder()
				.dinHeader(MapperDinHeader.mapperHeaderToDinnerHeader(headers))
				.dinBody(DinBodyAssessmentRq.builder()
									.perfil(request.getPartyAuthenticationAssessment().getPartyReference().getPartyType())
									.numeroIdentificacion(request.getPartyAuthenticationAssessment().getPartyReference().getIdentifications().get(0).getIdentifier().getIdentifierValue())
									.numeroInversion(request.getPartyAuthenticationAssessment().getPartyReference().getPartyProfile().getInvestmentNumber())
									.celular(validCel(request.getPartyAuthenticationAssessment().getPartyReference().getContactPoint()))
									.correo(validEmail(request.getPartyAuthenticationAssessment().getPartyReference().getContactPoint()))
									.esPersonaNaturalConRuc(request.getPartyAuthenticationAssessment().getPartyReference().isCorporateCustomer())
									.tipoInvocacion(request.getPartyAuthenticationAssessment().getAuthenticationType())
									.digitosTarjeta(request.getPaymentCard().getCardNumber())
									.fechaCaducidad(request.getPaymentCard().getCardExpiryDate())
									.cvv(request.getPaymentCard().getCardSecurityCode())
									.rucEmpresa(request.getOrganisation().getOrganisationIdentification().get(0).getIdentifier().getIdentifierValue())
									.usuarioBiometrico(request.getUsername())
									.tipoOperacion(request.getOperationType())
									.codigoUnicoAplicativo(request.getSourceCode())
									.codigoDactilar(request.getBiometricInstanceRecord().getAuthenticationBiometricRecord())
									.token(request.getTokenAssignment().getTokenIdentificationCode().getIdentifierValue().getValue())
									.origenInvocacion(request.getSourceRequest())
									.build())
				.build();
	}
	
	
	public static String validCel(List<ContactPoint> lstContactPoint) {
		final StringBuilder contactType= new StringBuilder();
		lstContactPoint.forEach(contact->{
			if(contact.getContactPointType().equalsIgnoreCase("Cellphone")) {
				contactType.append(contact.getContactPointValue());
			}
		});
		
		return contactType.toString();
	}

	public static String validEmail(List<ContactPoint> lstContactPoint) {
		final StringBuilder contactType= new StringBuilder();
		lstContactPoint.forEach(contact->{
			if(contact.getContactPointType().equalsIgnoreCase("Electronic Address") ) {
				contactType.append(contact.getContactPointValue());
			}
		});
		
		return contactType.toString();
	}
	
	
	public static  boolean getBoolean(Object input) {
		Boolean b = false;
		log.info("Input: {}",input);
		if(input != null) {
			String s = input.toString();	
			if ("true".equals(s) || "false".equals(s)) {
			   b= Boolean.parseBoolean(s);
			}
		}		
		return b;
	}
	
	public static int getInt(Object input) {
		int res = 0;
		log.info("Input: {}",input);
		if(input != null) {
			res=Integer.parseInt((String) input);
		}		
		return res;
	}
	
}


