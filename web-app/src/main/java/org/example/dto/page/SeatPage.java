package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatPage {
    private Long idSeat;
    private String placeSeat;
    private String typeSeat;
    private Boolean isOrderedSeat;

    private Long idAirPlane;
    private String typeAirPlane;
    private String statusAirPlane;
    private Integer numberSeatLowcostAirPlane;
    private Integer numberSeatBuisnessAirPlane;
    private Integer pricePerKilometerAirPlane;
    private Boolean isActiveAirPlane;
}
