package org.example.mapper.page;

import org.example.dto.models.AirCompanyDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.SeatDTO;
import org.example.dto.models.modif.AirPlaneDTOModif;
import org.example.dto.models.page.AirPlaneDTOModifPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirPlaneMapperPage {

    public AirPlaneDTOModifPage toPageDTO(AirPlaneDTOModif airPlaneDTOModif) {
        AirCompanyDTO airCompanyDTO = airPlaneDTOModif.getAirCompanyDTO();
        List<FlightRouteDTO> flightRouteDTOList = airPlaneDTOModif.getFlightRouteDTOList();
        List<SeatDTO> seatDTOList = airPlaneDTOModif.getSeatDTOList();
        return AirPlaneDTOModifPage.builder()
                .idAirPlane(airPlaneDTOModif.getId())
                .typeAirPlane(airPlaneDTOModif.getType())
                .statusAirPlane(airPlaneDTOModif.getStatus())
                .numberSeatLowcostAirPlane(airPlaneDTOModif.getNumberSeatLowcost())
                .numberSeatBuisnessAirPlane(airPlaneDTOModif.getNumberSeatBuisness())
                .isActiveAirPlane(airPlaneDTOModif.getIsActive())

                .idAirCompany(airCompanyDTO.getId())
                .nameAirCompany(airCompanyDTO.getNameCompany())
                .countryLocationAirCompany(airCompanyDTO.getCountryLocation())
                .priceLowcostIndexAirCompany(airCompanyDTO.getPriceLowcostIndex())
                .priceBuisnessIndexAirCompany(airCompanyDTO.getPriceBuisnessIndex())

                .idFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getId).collect(Collectors.toList()))
                .routeStartFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getRouteStart).collect(Collectors.toList()))
                .routeEndFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getRouteEnd).collect(Collectors.toList()))
                .distanceFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getDistance).collect(Collectors.toList()))
                .flightDateStartFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getFlightDateStart).collect(Collectors.toList()))
                .flightDateEndFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getFlightDateEnd).collect(Collectors.toList()))
                .isActiveFlightRoute(flightRouteDTOList.stream().map(FlightRouteDTO::getIsActive).collect(Collectors.toList()))

                .idSeat(seatDTOList.stream().map(SeatDTO::getId).collect(Collectors.toList()))
                .placeSeat(seatDTOList.stream().map(SeatDTO::getPlace).collect(Collectors.toList()))
                .typeSeat(seatDTOList.stream().map(SeatDTO::getType).collect(Collectors.toList()))
                .isOrderedSeat(seatDTOList.stream().map(SeatDTO::getIsOrdered).collect(Collectors.toList()))
                .build();
    }

    public List<AirPlaneDTOModifPage> toPageDTO(List<AirPlaneDTOModif> airPlaneDTOModifList) {
        return airPlaneDTOModifList.stream().map(this::toPageDTO).collect(Collectors.toList());
    }
}
