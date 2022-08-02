package org.example.dto.modelsDTO.modif2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.StatusDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDTOModif2 {
    private Long id;
    private StatusDTO statusDTO;
    private FlightRouteDTOModif2 flightRouteDTOModif2;
}
