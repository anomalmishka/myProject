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
public class AirPlane {
    private Long id;
    private String type;
    private String status;
    private Integer numberSeatLowcost;
    private Integer numberSeatBuisness;
    private Integer pricePerKilometer;
    private Boolean isActive;
    private AirCompany airCompany;
    private List<FlightRoute> flightRouteList;
    private List<Seat> seatList;
}
