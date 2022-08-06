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
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Timestamp flightDateStart;
    private Timestamp flightDateEnd;
    private Long duration;
    private Integer price;
    private Boolean isActive;
    private List<AirPlaneFlightRoutePage> airPlaneFlightRoutePageList;
}
