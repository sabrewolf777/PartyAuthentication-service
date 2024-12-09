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
public class DinBodyAssessmentRs {
    private String descripcionValidacion;
    private String codigoValidacion;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private boolean esAfiliadoWeb;
    private String usuarioBiometrico;
    private String codigoBloqueo;
    private String minutosRestantes;
    private String horasRestantes;
    private String tipoDigitos;
    private String token;
    private boolean registroCivilDisponible;
    private String fotografia;
    private String correoOTP;
    private String celularOTP;
    private boolean resultadoOtrasValidaciones;
    private boolean reingreso;
    private String origenBloqueo;
}
