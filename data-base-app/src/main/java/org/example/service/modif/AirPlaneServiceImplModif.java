package org.example.service.modif;

import lombok.RequiredArgsConstructor;
import org.example.dao.models.AirPlaneDAO;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.entity.Seat;
import org.example.service.models.api.AirCompanyService;
import org.example.service.models.api.FlightRouteService;
import org.example.service.models.api.SeatService;
import org.example.service.modif.api.AirPlaneServiceModif;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImplModif implements AirPlaneServiceModif {

    private final AirPlaneDAO airPlaneDAO;
    private final AirCompanyService airCompanyService;
    private final FlightRouteService flightRouteService;
    private final SeatService seatService;


    @Override
    public AirPlane create(AirPlane airPlane) {

        int seatPerRow = 6;
        int counterLowcost;
        int counterBuisness;
        Integer numberSeatLowcost = airPlane.getNumberSeatLowcost();
        Integer numberSeatBuisness = airPlane.getNumberSeatBuisness();
        List<Seat> seatList = new ArrayList<>();
        int numberRowLowcost = (numberSeatLowcost - numberSeatLowcost % seatPerRow) / seatPerRow + 1;
        int numberRowBuisness = (numberSeatBuisness - numberSeatBuisness % seatPerRow) / seatPerRow + 1;
        for (int x = 1; x <= numberRowLowcost; x++) {
            if (x == numberRowLowcost) {
                counterLowcost = numberSeatLowcost % seatPerRow;
            } else {
                counterLowcost = seatPerRow;
            }
            for (int i = 1; i <= counterLowcost; i++) {
                seatList.add(Seat.builder()
                        .place(seatPosition(i, x))
                        .type("Lowcost")
                        .isOrdered(false)
                        .build());
            }
        }
        for (int x = 1; x <= numberRowBuisness; x++) {
            if (x == numberRowBuisness) {
                counterBuisness = numberSeatBuisness % seatPerRow;
            } else {
                counterBuisness = seatPerRow;
            }
            for (int i = 1; i <= counterBuisness; i++) {
                seatList.add(Seat.builder()
                        .place(seatPosition(i, x))
                        .type("Buisness")
                        .isOrdered(false)
                        .build());
            }
        }
        AirPlane verifyModel = setForgetValueOnId(airPlane);
        verifyModel.setSeatList(seatList);
        return airPlaneDAO.save(verifyModel);
    }

    @Override
    public AirPlane update(AirPlane airPlane) {
        return airPlaneDAO.save(setForgetValueOnId(airPlane));
    }

    private AirPlane setForgetValueOnId(AirPlane airPlane) {
        if (airPlane.getType() != null) {
            Long airCompanyId = airPlane.getAirCompany().getId();
            AirCompany airCompany = airCompanyService.readById(airCompanyId);
            airPlane.setAirCompany(airCompany);
            List<Long> flightRouteIdList = airPlane.getFlightRouteList().stream().map(FlightRoute::getId).collect(Collectors.toList());
            List<FlightRoute> flightRouteList = flightRouteService.readAllByIds(flightRouteIdList);
            airPlane.setFlightRouteList(flightRouteList);
            List<Long> seatIdList = airPlane.getSeatList().stream().map(Seat::getId).collect(Collectors.toList());
            List<Seat> seatList = seatService.readAllByIds(seatIdList);
            airPlane.setSeatList(seatList);
            return airPlane;
        } else {
            throw new ErrorInvalidData("Type must not be null");
        }
    }

    private String seatPosition(int count, int row) {
        String rowPositionName = String.valueOf(row);
        switch (count) {
            case 1:
                rowPositionName = rowPositionName + "A";
                break;
            case 2:
                rowPositionName = rowPositionName + "B";
                break;
            case 3:
                rowPositionName = rowPositionName + "C";
                break;
            case 4:
                rowPositionName = rowPositionName + "D";
                break;
            case 5:
                rowPositionName = rowPositionName + "E";
                break;
            case 6:
                rowPositionName = rowPositionName + "F";
                break;
        }
        return rowPositionName;
    }
}
