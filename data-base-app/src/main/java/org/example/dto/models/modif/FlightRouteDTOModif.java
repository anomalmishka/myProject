package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.OrderDTO;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTOModif {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
    private List<OrderDTO> orderDTOList;
}
