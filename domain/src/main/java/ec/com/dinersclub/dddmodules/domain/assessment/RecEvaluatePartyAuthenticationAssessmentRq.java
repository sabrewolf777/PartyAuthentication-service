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
public class RecEvaluatePartyAuthenticationAssessmentRq {
    private PartyAuthenticationAssessment partyAuthenticationAssessment;
    private PaymentCard paymentCard;
    private Organisation organisation;
    private String username;
    private String operationType;
    private String sourceCode;
    private BiometricInstanceRecord biometricInstanceRecord;
    private TokenAssignment tokenAssignment;
    private String sourceRequest;

    // Clases internas
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyAuthenticationAssessment {
        private PartyReference partyReference;
        private String authenticationType;
    }
    
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyReference {
        private String partyType;
        private List<Identification> identifications;
        private PartyProfile partyProfile;
        private List<ContactPoint> contactPoint;
        private boolean corporateCustomer;

        // Clase interna para Identification
        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Identification {
            private Identifier identifier;
            private int personIdentificationType;

            @Getter
            @Setter
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Identifier {
                private String identifierValue;
            }
        }

        // Clase interna para PartyProfile
        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class PartyProfile {
            private String investmentNumber;
        }

        // Clase interna para ContactPoint
        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ContactPoint {
            private String contactPointValue;
            private String contactPointType;
        }
    }	
    
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentCard {
        private String cardNumber;
        private String cardExpiryDate;
        private String cardSecurityCode;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Organisation {
        private List<OrganisationIdentification> organisationIdentification;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrganisationIdentification {
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
    public static class BiometricInstanceRecord {
        private String authenticationBiometricRecord;
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
        private Value identifierValue;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Value {
        private String value;
    }
}
