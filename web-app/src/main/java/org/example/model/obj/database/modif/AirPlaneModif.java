package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.AirCompany;
import org.example.model.obj.database.model.FlightRoute;
import org.example.model.obj.database.model.Seat;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneModif {
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
