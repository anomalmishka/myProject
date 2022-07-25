package org.example.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfile {
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

