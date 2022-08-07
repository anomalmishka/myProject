package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.SeatDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTOModif {
    private Long id;
    private String type;
    private String status;
    private Integer numberSeatLowcost;
    private Integer numberSeatBuisness;
    private Boolean isActive;
    private AirCompanyDTO airCompany;
    private List<SeatDTO> seatList;
}
