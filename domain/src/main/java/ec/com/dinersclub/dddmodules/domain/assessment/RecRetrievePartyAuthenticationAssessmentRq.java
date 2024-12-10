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
public class RecRetrievePartyAuthenticationAssessmentRq {
    private PartyAuthenticationAssessment partyAuthenticationAssessment;
    private String username;
    private String operationType;
    private String sourceCode;
    private String sourceRequest;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartyAuthenticationAssessment {
        private PartyReference partyReference;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class PartyReference {
            private List<Identification> identifications;

            @Getter
            @Setter
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Identification {
                private Identifier identifier;

                @Getter
                @Setter
                @Builder
                @NoArgsConstructor
                @AllArgsConstructor
                public static class Identifier {
                    private String identifierValue;
                }
            }
        }
    }
}
