package org.example.service.filter.flightRoute;

import org.example.dto.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;

import java.util.List;

public interface FilterFlightRouteService {

    List<FlightRouteDTOModif2> findAll();
    //**************************************1***************************************************
    List<FlightRouteDTOModif2> findWhereName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteStart(FilterDTO filterDTO);

    //**************************************2***************************************************
    List<FlightRouteDTOModif2> findWhereRoute(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDate(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWherePrice(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDuration(FilterDTO filterDTO);


    //**************************************3***************************************************
    List<FlightRouteDTOModif2> findWhereRouteName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDateName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWherePriceName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereRouteTransfer(FilterDTO filterDTO);


    //**************************************4***************************************************
    List<FlightRouteDTOModif2> findWhereRouteDate(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereRoutePrice(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDuration(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDatePrice(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDateDuration(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWherePriceDuration(FilterDTO filterDTO);

    //**************************************5***************************************************
    List<FlightRouteDTOModif2> findWhereRouteDateName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereRoutePriceName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDurationName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereDatePriceName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereDateDurationName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWherePriceDurationName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDateTransfer(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereRoutePriceTransfer(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDurationTransfer(FilterDTO filterDTO);

    //**************************************6***************************************************

    List<FlightRouteDTOModif2> findWhereRouteDatePrice(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDateDuration(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRoutePriceDuration(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereDatePriceDuration(FilterDTO filterDTO);

    //**************************************7***************************************************
    List<FlightRouteDTOModif2> findWhereRouteDatePriceName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDateDurationName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRoutePriceDurationName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereDatePriceDurationName(FilterDTO filterDTO);

    List<FlightRouteDTOModif2> findWhereRouteDatePriceTransfer(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDateDurationTransfer(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRoutePriceDurationTransfer(FilterDTO filterDTO);

    //**************************************8***************************************************
    List<FlightRouteDTOModif2> findWhereRouteDatePriceDuration(FilterDTO filterDTO);
    //**************************************9***************************************************
    List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationName(FilterDTO filterDTO);
    List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfser(FilterDTO filterDTO);
    //**************************************10**************************************************
    List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfserName(FilterDTO filterDTO);
}
