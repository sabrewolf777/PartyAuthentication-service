package ec.com.dinersclub.dddmodules.domain.model.token;

import java.util.List;

import lombok.*;

@Data
@Builder
public class DinOtpRq {
    private DinHeader dinHeader;
    private DinBody dinBody;

} 