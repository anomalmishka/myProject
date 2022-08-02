package org.example.dto.modelsDTO.modif2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTOModif2 {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Timestamp flightDateStart;
    private Timestamp flightDateEnd;
    private Integer price;
    private Boolean isActive;
    private List<AirPlaneFlightRouteDTOModif2> airPlaneFlightRouteDTOModif2List;
}
