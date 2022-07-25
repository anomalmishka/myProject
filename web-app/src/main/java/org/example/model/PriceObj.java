package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Integer> priceLowcostSeat;
    private List<Integer> priceBuisnessSeat;

}
