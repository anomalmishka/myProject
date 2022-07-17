package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.TicketDTO;

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
    private Integer ticketPrice;
    private Integer numberPassanger;
    private Date flightDateStart;
    private Date flightDateEnd;
    private List<TicketDTO> ticketDTOS;
}
