package org.example.service.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.Seat;
import org.example.service.models.api.AirCompanyService;
import org.example.service.models.api.AirPlaneService;
import org.example.service.models.api.SeatService;
import org.example.service.models.modif.api.AirPlaneServiceModif;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AirPlaneServiceImplModif implements AirPlaneServiceModif {

    private final AirPlaneService airPlaneService;

    private final AirCompanyService airCompanyService;
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
        if (airPlane.getAirCompany().getId()!=null) {
            AirPlane verifyModel = setForgetValueOnId(airPlane);
            verifyModel.setSeatList(seatList);
            return airPlaneService.create(verifyModel);
        }
        else {
            throw new ErrorInvalidData("AirCompany must not be null");
        }

    }

    @Override
    public List<AirPlane> readAll() {
        return airPlaneService.readAll();
    }

    @Override
    public AirPlane readById(Long id) {
        return airPlaneService.readById(id);
    }

    @Override
    public List<AirPlane> readAllByIds(List<Long> ids) {
        return airPlaneService.readAllByIds(ids);
    }

    @Override
    public AirPlane deleteById(Long id) {
        return airPlaneService.deleteById(id);
    }

    @Override
    public List<AirPlane> deleteAllByIds(List<Long> ids) {
        return airPlaneService.deleteAllByIds(ids);
    }

    @Override
    public AirPlane update(AirPlane airPlane) {
        return airPlaneService.update(setForgetValueOnId(airPlane));
    }

    private AirPlane setForgetValueOnId(AirPlane airPlane) {
        if (airPlane.getType() != null) {
            Long airCompanyId = airPlane.getAirCompany().getId();
            AirCompany airCompany = airCompanyService.readById(airCompanyId);
            airPlane.setAirCompany(airCompany);
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
