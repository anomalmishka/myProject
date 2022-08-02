package org.example.dto.modelsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteDTO {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Timestamp flightDateStart;
    private Timestamp flightDateEnd;
    private Integer price;
    private Boolean isActive;
}
