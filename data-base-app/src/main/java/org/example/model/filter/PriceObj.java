package org.example.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceObj {
    private Long idAirCompany;
    private Long idAirPlane;
    private Long idFlightRoute;
    private List<Integer> totalPriceFlyList;
    private List<AirCompany> airCompanyList;
    private List<AirPlane> airPlaneList;
    private List<FlightRoute> flightRouteList;
}
