package org.example.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRoute {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
    private List<AirPlane> airPlaneList;
    private List<UserOrder> userOrderList;
}
