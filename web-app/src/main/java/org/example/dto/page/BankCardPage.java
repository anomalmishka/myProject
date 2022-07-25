package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankCardPage {
    private Long idBankCard;
    private Long cardNumberBankCard;

    private Long idUserProfile;
    private String nameUserProfile;
    private String lastnameUserProfile;
    private Integer phoneUserProfile;
    private String emailUserProfile;
    private Boolean isBlockedProfileUserProfile;
    private Long userIdUserProfile;
}
