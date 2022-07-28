package org.example.service.filter;

import lombok.RequiredArgsConstructor;
import org.example.exception.ErrorInvalidData;
import org.example.model.entity.AirCompany;
import org.example.model.entity.AirPlane;
import org.example.model.entity.FlightRoute;
import org.example.model.filter.PriceObj;
import org.example.service.models.api.FlightRouteService;
import org.example.service.filter.api.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final FlightRouteService flightRouteService;

    @Override
    public PriceObj getPriceWhereFlightRoute(PriceObj priceObj) {
        if (priceObj.getIdFlightRoute() != null) {
            Long idFlightRoute = priceObj.getIdFlightRoute();
            FlightRoute flightRoute = flightRouteService.readById(idFlightRoute);
            Integer distance = flightRoute.getDistance();
//            List<AirPlane> airPlaneList = flightRoute.getAirPlaneList();
//            List<Integer> pricePerKilometerList = airPlaneList.stream().map(AirPlane::getPricePerKilometer).collect(Collectors.toList());
//            List<AirCompany> airCompanyList = airPlaneList.stream().map(AirPlane::getAirCompany).collect(Collectors.toList());
//            List<Integer> priceLowcostIndex = airCompanyList.stream().map(AirCompany::getPriceLowcostIndex).collect(Collectors.toList());
//            List<Integer> priceBuisnessIndex = airCompanyList.stream().map(AirCompany::getPriceBuisnessIndex).collect(Collectors.toList());
//            List<Integer> totalPriceFlyList = pricePerKilometerList.stream().map(pricePerKilometer -> pricePerKilometer * distance).collect(Collectors.toList());
//            List<Integer> numberSeatLowcostList = airPlaneList.stream().map(AirPlane::getNumberSeatLowcost).collect(Collectors.toList());
//            List<Integer> numberSeatBuisnessList = airPlaneList.stream().map(AirPlane::getNumberSeatBuisness).collect(Collectors.toList());
//            List<Integer> numberSeatAllList = IntStream.range(0, numberSeatLowcostList.size())
//                    .mapToObj(i -> numberSeatLowcostList.get(i) + numberSeatBuisnessList.get(i))
//                    .collect(Collectors.toList());
//            List<Integer> pricePerSeat = IntStream.range(0, numberSeatAllList.size())
//                    .mapToObj(i -> totalPriceFlyList.get(i) / numberSeatAllList.get(i))
//                    .collect(Collectors.toList());
//            List<Integer> priceLowcostSeat = IntStream.range(0, pricePerSeat.size())
//                    .mapToObj(i -> pricePerSeat.get(i) * priceLowcostIndex.get(i))
//                    .collect(Collectors.toList());
//            List<Integer> priceBuisnessSeat = IntStream.range(0, pricePerSeat.size())
//                    .mapToObj(i -> pricePerSeat.get(i) * priceBuisnessIndex.get(i))
//                    .collect(Collectors.toList());
//            priceObj.setPriceLowcostSeat(priceLowcostSeat);
//            priceObj.setPriceBuisnessSeat(priceBuisnessSeat);
//            priceObj.setTotalPriceFlyList(totalPriceFlyList);
        } else {
            throw new ErrorInvalidData("IdFlightRoute must not be null");
        }
        return priceObj;
    }
}
