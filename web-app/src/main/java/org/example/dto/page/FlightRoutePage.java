package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRoutePage {
    private String id;
    private String routeStart;
    private String routeEnd;
    private String distance;
    private String flightDateStart;
    private String flightDateEnd;
    private String duration;
    private String price;
    private List<AirPlaneFlightRoutePage> airPlaneFlightRouteList;
    private String isActive;
}
