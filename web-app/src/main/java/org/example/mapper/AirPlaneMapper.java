package org.example.mapper;

import org.example.dto.models.TicketDTO;
import org.example.dto.models.modif.*;
import org.example.model.filter.AirPlaneObj;
import org.example.model.filter.AirPlaneObjList;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneMapper {

    public AirPlaneDTOModif toDTO(AirPlaneObj airPlaneObj) {
        List<TicketDTO> ticketDTOS = List.of(TicketDTO.builder()
                .id(airPlaneObj.getIdTicket())
                .passengerSeat(airPlaneObj.getPassengerSeatTicket())
                .isEmptySeat(airPlaneObj.getIsEmptySeatTicket())
                .isActive(airPlaneObj.getIsActiveTicket())
                .build());
        return AirPlaneDTOModif.builder()
                .id(airPlaneObj.getIdAirPlane())
                .type(airPlaneObj.getTypeAirPlane())
                .routeStart(airPlaneObj.getRouteStartAirPlane())
                .routeEnd(airPlaneObj.getRouteEndAirPlane())
                .ticketPrice(airPlaneObj.getTicketPriceAirPlane())
                .numberPassanger(airPlaneObj.getNumberPassangerAirPlane())
                .flightDateStart(airPlaneObj.getFlightDateStartAirPlane())
                .flightDateEnd(airPlaneObj.getFlightDateEndAirPlane())
                .ticketDTOS(ticketDTOS)
                .build();
    }

    public List<AirPlaneDTOModif> toDTO(List<AirPlaneObj> airPlaneObjs) {
        return airPlaneObjs.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AirPlaneObjList> toModel(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return airPlaneDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public AirPlaneObjList toModel(AirPlaneDTOModif airPlaneDTOModif) {
        List<TicketDTO> ticketDTOS = airPlaneDTOModif.getTicketDTOS();
        return AirPlaneObjList.builder()
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
