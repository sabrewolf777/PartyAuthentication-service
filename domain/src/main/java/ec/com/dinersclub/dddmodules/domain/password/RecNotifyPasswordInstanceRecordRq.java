package ec.com.dinersclub.dddmodules.domain.password;

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
public class RecNotifyPasswordInstanceRecordRq {
    private String username;
    private PasswordInstanceRecord passwordInstanceRecord;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PasswordInstanceRecord {
        private String authenticationPasswordTestResult;
    }
}
