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
public class RecNotifyPasswordInstanceRecordRs {
    private PasswordInstanceRecord passwordInstanceRecord;
    private StatusInstanceRecord statusInstanceRecord;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PasswordInstanceRecord {
        private UsageLog usageLog;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class UsageLog {
            private LogEntry logEntry;

            @Getter
            @Setter
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class LogEntry {
                private String logEntryValueDate;
                private String logEntryValueTime;
            }
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusInstanceRecord {
        private String statusType;
        private String transactionDate;
        private String status;
        private String statusCode;
        private String providerCode;
        private String message;
        private String description;
    }
}
