package ec.com.dinersclub.dddmodules.domain.password;

import ec.com.dinersclub.dddmodules.domain.model.token.DinHeader;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinNotifRq {
	private DinHeader dinHeader;
	private DinBodyNotifRq dinBody;
}
