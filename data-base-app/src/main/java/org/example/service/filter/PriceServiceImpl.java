package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.PriceObj;
import org.example.service.api.AirPlaneService;
import org.example.service.filter.api.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final AirPlaneService airPlaneService;

    @Override
    public PriceObj getTotalFlyPriceWhereAirPlane(PriceObj priceObj) {
        Long idAirPlane = priceObj.getIdAirPlane();
        AirPlane airPlane = airPlaneService.readById(idAirPlane);
        Integer pricePerKilometer = airPlane.getPricePerKilometer();
        List<FlightRoute> flightRouteList = airPlane.getFlightRouteList();
        List<Integer> getDistanceList = flightRouteList.stream().map(FlightRoute::getDistance).collect(Collectors.toList());
        List<Integer> totalFlyPrice = getDistanceList.stream().map(integer -> integer * pricePerKilometer).collect(Collectors.toList());
        priceObj.setTotalPriceFlyList(totalFlyPrice);
        priceObj.setFlightRouteList(flightRouteList);
        return priceObj;
    }
}
