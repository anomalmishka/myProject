package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.AirPlaneFlightRouteDTO;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTOModif {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Timestamp flightDateStart;
    private Timestamp flightDateEnd;
    private Integer price;
    private Boolean isActive;
    private List<AirPlaneFlightRouteDTO> airPlaneFlightRouteDTOList;
}
