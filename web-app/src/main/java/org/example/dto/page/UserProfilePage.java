package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.models.modif.PassengerProfileDTOModif;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfilePage {
    private Long id;
    private String profilename;
    private String lastname;
    private Integer phone;
    private String email;
    private Boolean isBlockedProfile;
    private Long userId;
    private List<BankCardDTO> bankCardList;
    private List<PassengerProfileDTOModif> passengerProfileList;
}

