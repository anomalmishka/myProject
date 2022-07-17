package org.example.dto.modelsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTO {
    private Long id;
    private String type;
    private String routeStart;
    private String routeEnd;
    private Integer ticketPrice;
    private Integer numberPassanger;
    private Date flightDateStart;
    private Date flightDateEnd;
}
