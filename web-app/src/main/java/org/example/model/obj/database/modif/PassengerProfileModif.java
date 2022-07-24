package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.UserOrder;
import org.example.model.obj.database.model.UserProfile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileModif {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
    private UserProfile userProfile;
    private List<UserOrder> userOrderList;
}

