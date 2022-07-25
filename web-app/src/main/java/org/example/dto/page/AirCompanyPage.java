package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyPage {
    private Long idAirCompany;
    private String nameAirCompany;
    private String countryLocationAirCompany;
    private Integer priceLowcostIndexAirCompany;
    private Integer priceBuisnessIndexAirCompany;

    private List<Long> idAirPlane;
    private List<String> typeAirPlane;
    private List<String> statusAirPlane;
    private List<Integer> numberSeatLowcostAirPlane;
    private List<Integer> numberSeatBuisnessAirPlane;
    private List<Integer> pricePerKilometerAirPlane;
    private List<Boolean> isActiveAirPlane;
}
