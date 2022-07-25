package org.example.dto.page;

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
public class FlightRoutePage {
    private Long idFlightRoute;
    private String routeStartFlightRoute;
    private String routeEndFlightRoute;
    private Integer distanceFlightRoute;
    private Date flightDateStartFlightRoute;
    private Date flightDateEndFlightRoute;
    private Boolean isActiveFlightRoute;

    private List<Long> idAirPlane;
    private List<String> typeAirPlane;
    private List<String> statusAirPlane;
    private List<Integer> numberSeatLowcostAirPlane;
    private List<Integer> numberSeatBuisnessAirPlane;
    private List<Integer> pricePerKilometerAirPlane;
    private List<Boolean> isActiveAirPlane;

    private List<Long> idUserOrder;
}
