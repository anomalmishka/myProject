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
public class PassengerProfilePage {
    private Long idPassengerProfile;
    private String namePassengerProfile;
    private String lastnamePassengerProfile;
    private String passportNumberPassengerProfile;

    private Long idUserProfile;
    private String nameUserProfile;
    private String lastnameUserProfile;
    private Integer phoneUserProfile;
    private String emailUserProfile;
    private Boolean isBlockedProfileUserProfile;
    private Long userIdUserProfile;

    private List<Long> idUserOrder;
}

