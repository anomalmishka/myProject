package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.models.PassengerProfileDTO;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfileDTOModif {
    private Long id;
    private String name;
    private String lastname;
    private Integer phone;
    private String email;
    private Boolean isBlockedProfile;
    private Long userId;
    private List<BankCardDTO> bankCardDTOList;
    private List<PassengerProfileDTO> passengerProfileDTOList;
}

