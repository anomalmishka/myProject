package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.BankCardDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfileDTOModif {
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

