package org.example.dto;

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
    private Integer numberPassanger;
    private Date flightDate;
}
