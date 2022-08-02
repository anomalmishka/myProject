package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.AirCompanyDTO;
import org.example.dto.modelsDTO.SeatDTO;

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
    private AirCompanyDTO airCompanyDTO;
    private List<SeatDTO> seatDTOList;
}
