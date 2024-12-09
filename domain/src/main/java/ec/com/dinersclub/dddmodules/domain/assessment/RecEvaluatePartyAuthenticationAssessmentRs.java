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
public class RecEvaluatePartyAuthenticationAssessmentRs {
    private PartyAuthenticationAssessment partyAuthenticationAssessment;
    private String username;
    private TokenAssignment tokenAssignment;
    private BiometricInstanceRecord biometricInstanceRecord;
    private String migrationType;
    private StatusInstanceRecord statusInstanceRecord;

    // Clases internas
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyAuthenticationAssessment {
        private String authenticationDescription;
        private String customerContactAuthenticationLevel;
        private PartyReference partyReference;
        private String authenticationLockType;
        private int authenticationLockMinutes;
        private int authenticationLockHours;
        private String authenticationMethod;
        private boolean partyAuthenticationConsolidationRecord;
        private boolean authenticationInput;
        private String authenticationLockSource;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyReference {
        private List<Identification> identifications;
        private PartyProfile partyProfile;
        private boolean civilRegistryAvailability;
        private List<ContactPoint> contactPoint;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Identification {
        private int personIdentificationType;
        private Identifier identifier;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Identifier {
        private String identifierValue;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyProfile {
        private boolean webSubsidiary;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactPoint {
        private String contactPointValue;
        private String contactPointType;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenAssignment {
        private TokenIdentificationCode tokenIdentificationCode;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TokenIdentificationCode {
        private IdentifierValue identifierValue;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdentifierValue {
        private String value;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BiometricInstanceRecord {
        private String authenticationBiometricFile;
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
