package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDataDTO {
    private Long idFlightRoute;
    private Long idAirPlane;
    private Long idSeat;
    private Long idPassangerProfile;
    private Long userOrderStatus;
    private String username;
}


