package ec.com.dinersclub.dddmodules.domain.model.token;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
	 private String clave;
	 private String valor;
}
