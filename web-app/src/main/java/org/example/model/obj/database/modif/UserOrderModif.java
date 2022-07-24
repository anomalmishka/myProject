package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.FlightRoute;
import org.example.model.obj.database.model.PassengerProfile;
import org.example.model.obj.database.model.Status;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderModif {
    private Long id;
    private Status status;
    private FlightRoute flightRoute;
    private PassengerProfile passengerProfile;
}
