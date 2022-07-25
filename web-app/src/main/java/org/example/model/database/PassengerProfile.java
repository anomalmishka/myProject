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
public class PassengerProfile {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
    private UserProfile userProfile;
    private List<UserOrder> userOrderList;
}

