package ec.com.dinersclub.dddmodules.domain.assessment;

import ec.com.dinersclub.dddmodules.domain.model.token.DinHeader;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinAssessmentRq {
	private DinHeader dinHeader;
	private DinBodyAssessmentRq dinBody;
}
