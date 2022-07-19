package org.example.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BuisnessObj {
    private Long idAirPlane;
    private String typeAirPlane;
    private String routeStartAirPlane;
    private String routeEndAirPlane;
    private Integer ticketPriceAirPlane;
    private Integer numberPassangerAirPlane;
    private Date flightDateStartAirPlane;
    private Date flightDateEndAirPlane;

    private Long idTicket;
    private Integer passengerSeatTicket;
    private Boolean isEmptySeatTicket;
    private Boolean isActiveTicket;

}
