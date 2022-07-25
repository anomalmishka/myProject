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
public class AirPlanePage {
    private Long idAirPlane;
    private String typeAirPlane;
    private String statusAirPlane;
    private Integer numberSeatLowcostAirPlane;
    private Integer numberSeatBuisnessAirPlane;
    private Integer pricePerKilometerAirPlane;
    private Boolean isActiveAirPlane;

    private Long idAirCompany;
    private String nameAirCompany;
    private String countryLocationAirCompany;
    private Integer priceLowcostIndexAirCompany;
    private Integer priceBuisnessIndexAirCompany;

    private List<Long> idFlightRoute;
    private List<String> routeStartFlightRoute;
    private List<String> routeEndFlightRoute;
    private List<Integer> distanceFlightRoute;
    private List<Date> flightDateStartFlightRoute;
    private List<Date> flightDateEndFlightRoute;
    private List<Boolean> isActiveFlightRoute;

    private List<Long> idSeat;
    private List<String> placeSeat;
    private List<String> typeSeat;
    private List<Boolean> isOrderedSeat;
}
