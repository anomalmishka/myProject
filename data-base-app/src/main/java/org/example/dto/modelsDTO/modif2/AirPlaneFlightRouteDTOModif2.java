package org.example.dto.modelsDTO.modif2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.modif.AirPlaneDTOModif;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneFlightRouteDTOModif2 {
    private Long id;
    private AirPlaneDTOModif airPlaneDTOModif;
}
