package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDataPage {
    private String idFlightRoute;
    private String idAirPlane;
    private String idSeat;
    private String idPassangerProfile;
    private String userOrderStatus;
    private String username;
}


