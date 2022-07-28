package org.example.dto.ladder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTOLadder {
    private Long id;
    private String type;
    private String status;
    private Integer numberSeatLowcost;
    private Integer numberSeatBuisness;
    private Integer pricePerKilometer;
    private Boolean isActive;
    private List<FlightRouteDTOLdder> flightRouteDTOLdderList;
    private List<SeatDTOLadder> seatDTOLadderList;
}
