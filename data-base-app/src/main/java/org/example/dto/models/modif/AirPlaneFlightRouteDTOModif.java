package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneFlightRouteDTOModif {
    private Long id;
    private AirPlaneDTOModif airPlaneDTOModif;
}
