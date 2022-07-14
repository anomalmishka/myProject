package org.example.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.AirPlane;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyDTOModif {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private List<AirPlaneDTOModif> airPlaneDTOModifs;
}
