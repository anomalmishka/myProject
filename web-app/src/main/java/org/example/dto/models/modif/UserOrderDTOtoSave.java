package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.PassengerProfileDTO;
import org.example.dto.models.StatusDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDTOtoSave {
    private Long id;
    private StatusDTO status;
    private FlightRouteDTO flightRoute;
    private PassengerProfileDTO passengerProfile;
}
