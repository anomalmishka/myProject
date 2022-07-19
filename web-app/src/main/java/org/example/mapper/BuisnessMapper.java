package org.example.mapper;

import org.example.dto.modelsDTO.TicketDTO;
import org.example.dto.modelsDTO.modif.*;
import org.example.model.filter.BuisnessObj;
import org.example.model.filter.BuisnessObjList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuisnessMapper {

    public AirPlaneDTOModif toDTO(BuisnessObj buisnessObj) {
        List<TicketDTO> ticketDTOS = List.of(TicketDTO.builder()
                .id(buisnessObj.getIdTicket())
                .passengerSeat(buisnessObj.getPassengerSeatTicket())
                .isEmptySeat(buisnessObj.getIsEmptySeatTicket())
                .isActive(buisnessObj.getIsActiveTicket())
                .build());
        return AirPlaneDTOModif.builder()
                .id(buisnessObj.getIdAirPlane())
                .type(buisnessObj.getTypeAirPlane())
                .routeStart(buisnessObj.getRouteStartAirPlane())
                .routeEnd(buisnessObj.getRouteEndAirPlane())
                .ticketPrice(buisnessObj.getTicketPriceAirPlane())
                .numberPassanger(buisnessObj.getNumberPassangerAirPlane())
                .flightDateStart(buisnessObj.getFlightDateStartAirPlane())
                .flightDateEnd(buisnessObj.getFlightDateEndAirPlane())
                .ticketDTOS(ticketDTOS)
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<BuisnessObj> buisnessObjs) {
        return buisnessObjs.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<BuisnessObjList> toModel(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return airPlaneDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public BuisnessObjList toModel(AirPlaneDTOModif airPlaneDTOModif) {
        List<TicketDTO> ticketDTOS = airPlaneDTOModif.getTicketDTOS();
        return BuisnessObjList.builder()
                .idAirPlane(airPlaneDTOModif.getId())
                .typeAirPlane(airPlaneDTOModif.getType())
                .routeStartAirPlane(airPlaneDTOModif.getRouteStart())
                .routeEndAirPlane(airPlaneDTOModif.getRouteEnd())
                .ticketPriceAirPlane(airPlaneDTOModif.getTicketPrice())
                .numberPassangerAirPlane(airPlaneDTOModif.getNumberPassanger())
                .flightDateStartAirPlane(airPlaneDTOModif.getFlightDateStart())
                .flightDateEndAirPlane(airPlaneDTOModif.getFlightDateEnd())
                .idTicket(ticketDTOS.stream().map(TicketDTO::getId).collect(Collectors.toList()))
                .passengerSeatTicket(ticketDTOS.stream().map(TicketDTO::getPassengerSeat).collect(Collectors.toList()))
                .isEmptySeatTicket(ticketDTOS.stream().map(TicketDTO::getIsEmptySeat).collect(Collectors.toList()))
                .isActiveTicket(ticketDTOS.stream().map(TicketDTO::getIsActive).collect(Collectors.toList()))
                .build();
    }
}
