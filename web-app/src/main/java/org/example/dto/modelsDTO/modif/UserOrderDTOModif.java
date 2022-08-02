package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.FlightRouteDTO;
import org.example.dto.modelsDTO.StatusDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDTOModif {
    private Long id;
    private StatusDTO statusDTO;
    private FlightRouteDTO flightRouteDTO;
}
