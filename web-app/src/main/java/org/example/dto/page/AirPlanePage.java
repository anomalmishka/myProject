package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlanePage {
    private Long id;
    private String type;
    private String status;
    private Integer numberSeatLowcost;
    private Integer numberSeatBuisness;
    private Boolean isActive;
    private AirCompanyPage airCompany;
    private List<SeatPage> seatList;
}
