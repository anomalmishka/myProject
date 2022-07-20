package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTOModif {
    private Long id;
    private String type;
    private Integer numberSeat;
    private List<FlightRouteDTOModif> flightRouteDTOModifList;
    private List<SeatDTOModif> seatDTOModifList;
}
