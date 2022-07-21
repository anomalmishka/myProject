package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTO {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
}
