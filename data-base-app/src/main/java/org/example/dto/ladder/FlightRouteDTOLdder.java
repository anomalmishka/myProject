package org.example.dto.ladder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTOLdder {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
}
