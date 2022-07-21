package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.FlightRouteDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyDTOModif {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private List<AirPlaneDTO> airPlaneDTOList;
    private List<FlightRouteDTO> flightRouteDTOList;
}
