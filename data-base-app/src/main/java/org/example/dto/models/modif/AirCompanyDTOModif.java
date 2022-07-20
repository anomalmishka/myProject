package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyDTOModif {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private List<AirPlaneDTOModif> airPlaneDTOModifList;
    private List<FlightRouteDTOModif> flightRouteDTOModifList;
}
