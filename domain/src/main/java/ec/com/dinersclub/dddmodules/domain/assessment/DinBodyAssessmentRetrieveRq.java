package ec.com.dinersclub.dddmodules.domain.assessment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinBodyAssessmentRetrieveRq {
	private String numerdoIdentificacion;
	private String usuarioBiometrico;
	private String tipoOperacion;
	private String codigoUnicoAplicativo;
	private String origenInvocacion;
}
