package org.example.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceDTO {
    private Long idAirCompany;
    private Long idAirPlane;
    private Long idFlightRoute;
    private List<Integer> totalPriceFlyList;
    private List<AirCompanyDTO> airCompanyDTOList;
    private List<AirPlaneDTO> airPlaneDTOList;
    private List<FlightRouteDTO> flightRouteDTOList;
}
