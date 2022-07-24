package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.BankCard;
import org.example.model.obj.database.model.PassengerProfile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfileModif {
    private Long id;
    private String name;
    private String lastname;
    private Integer phone;
    private String email;
    private Boolean isBlockedProfile;
    private Long userId;
    private List<BankCard> bankCardList;
    private List<PassengerProfile> passengerProfileList;
}

