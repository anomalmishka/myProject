package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirPlaneDTO {
    private Long id;
    private String type;
    private String status;
    private Integer numberSeatLowcost;
    private Integer numberSeatBuisness;
    private Integer priceLowcost;
    private Integer priceBuisness;
    private Boolean isActive;
}
