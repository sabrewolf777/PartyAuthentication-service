package ec.com.dinersclub.dddmodules.domain.assessment;

import ec.com.dinersclub.dddmodules.domain.model.token.DinHeader;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DinAssessmentRetrieveRq {
	private DinHeader dinHeader;
	private DinBodyAssessmentRetrieveRq dinBody;
}
