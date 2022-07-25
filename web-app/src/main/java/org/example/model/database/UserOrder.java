package org.example.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrder {
    private Long id;
    private Status status;
    private FlightRoute flightRoute;
    private PassengerProfile passengerProfile;
}
