package org.example.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Ticket;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTOModif {
    private Long id;
    private String type;
    private String routeStart;
    private String routeEnd;
    private Integer numberPassanger;
    private Date flightDate;
    private List<Ticket> tickets;
}
