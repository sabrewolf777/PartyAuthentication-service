package ec.com.dinersclub.dddmodules.domain.assessment;

import java.util.List;

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
public class RecRetrievePartyAuthenticationAssessmentRs {
    private PartyAuthenticationAssessment partyAuthenticationAssessment;
    private StatusInstanceRecord statusInstanceRecord;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyAuthenticationAssessment {
        private PartyReference partyReference;
        private String authenticationLockType;
        private int authenticationLockMinutes;
        private int authenticationLockHours;
        private String authenticationLockSource;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class PartyReference {
            private String partyType;
            private List<Identification> identifications;
            private PartyProfile partyProfile;

            @Getter
            @Setter
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Identification {
                private int personIdentificationType;
            }

            @Getter
            @Setter
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class PartyProfile {
                private boolean investmentPaymentCard;
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
