package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.AirPlaneDTO;
import org.example.dto.models.SeatDTO;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CompleteFlightRouteDTO {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
    private List<AirCompanyDTO> airCompanyDTOList;
    private List<AirPlaneDTO> airPlaneDTOList;
    private List<SeatDTO> seatDTOList;
}
