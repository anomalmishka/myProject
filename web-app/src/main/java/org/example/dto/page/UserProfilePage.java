package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfilePage {
    private Long id;
    private String name;
    private String lastname;
    private Integer phone;
    private String email;
    private Boolean isBlockedProfile;
    private Long userId;

    private List<Long> idBankCard;
    private List<Long> cardNumberBankCard;

    private List<Long> idPassengerProfile;
    private List<String> namePassengerProfile;
    private List<String> lastnamePassengerProfile;
    private List<String> passportNumberPassengerProfile;
}

