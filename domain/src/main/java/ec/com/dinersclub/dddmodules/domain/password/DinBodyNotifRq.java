package ec.com.dinersclub.dddmodules.domain.password;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinBodyNotifRq {
	private String usuario;
	private String resultado;	
}	
