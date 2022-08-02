package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.AirPlaneDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneFlightRouteDTOModif {
    private Long id;
    private AirPlaneDTO airPlaneDTO;
}
