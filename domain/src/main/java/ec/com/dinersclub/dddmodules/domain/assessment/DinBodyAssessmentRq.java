package ec.com.dinersclub.dddmodules.domain.assessment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DinBodyAssessmentRq {
    private String perfil;
    private String numeroIdentificacion;
    private String tipoInvocacion;
    private String digitosTarjeta;
    private String numeroInversion;
    private String celular;
    private String rucEmpresa;
    private String usuarioBiometrico;
    private String tipoOperacion;
    private String codigoUnicoAplicativo;
    private boolean esPersonaNaturalConRuc;
    private String codigoDactilar;
    private String correo;
    private String fechaCaducidad;
    private String cvv;
    private String token;
    private String origenInvocacion;
}
