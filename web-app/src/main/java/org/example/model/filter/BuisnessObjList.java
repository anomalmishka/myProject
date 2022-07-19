package org.example.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BuisnessObjList {
    private Long idAirPlane;
    private String typeAirPlane;
    private String routeStartAirPlane;
    private String routeEndAirPlane;
    private Integer ticketPriceAirPlane;
    private Integer numberPassangerAirPlane;
    private Date flightDateStartAirPlane;
    private Date flightDateEndAirPlane;
   
    private List<Long> idTicket;
    private List<Integer> passengerSeatTicket;
    private List<Boolean> isEmptySeatTicket;
    private List<Boolean> isActiveTicket;
}
