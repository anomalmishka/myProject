package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.StatusDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDTOModif {
    private Long id;
    private StatusDTO status;
    private FlightRouteDTOModif flightRoute;
}
