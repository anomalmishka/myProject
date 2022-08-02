package org.example.dao.custom.flightRoute;

import org.example.model.entity.FlightRoute;
import org.example.model.filter.FilterObj;

import java.util.List;

public interface FlightRouteCustomDAO {
    //**************************************1***************************************************
    List<FlightRoute> findWhereName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteStart(FilterObj filterObj);

    //**************************************2***************************************************
    List<FlightRoute> findWhereRoute(FilterObj filterObj);

    List<FlightRoute> findWhereDate(FilterObj filterObj);

    List<FlightRoute> findWherePrice(FilterObj filterObj);

    List<FlightRoute> findWhereDuration(FilterObj filterObj);


    //**************************************3***************************************************
    List<FlightRoute> findWhereRouteName(FilterObj filterObj);

    List<FlightRoute> findWhereDateName(FilterObj filterObj);

    List<FlightRoute> findWherePriceName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteTransfer(FilterObj filterObj);


    //**************************************4***************************************************
    List<FlightRoute> findWhereRouteDate(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePrice(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDuration(FilterObj filterObj);

    List<FlightRoute> findWhereDatePrice(FilterObj filterObj);

    List<FlightRoute> findWhereDateDuration(FilterObj filterObj);

    List<FlightRoute> findWherePriceDuration(FilterObj filterObj);

    //**************************************5***************************************************
    List<FlightRoute> findWhereRouteDateName(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePriceName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereDatePriceName(FilterObj filterObj);

    List<FlightRoute> findWhereDateDurationName(FilterObj filterObj);

    List<FlightRoute> findWherePriceDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDateTransfer(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePriceTransfer(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDurationTransfer(FilterObj filterObj);

    //**************************************6***************************************************

    List<FlightRoute> findWhereRouteDatePrice(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDateDuration(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePriceDuration(FilterObj filterObj);

    List<FlightRoute> findWhereDatePriceDuration(FilterObj filterObj);

    //**************************************7***************************************************
    List<FlightRoute> findWhereRouteDatePriceName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDateDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePriceDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereDatePriceDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDatePriceTransfer(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDateDurationTransfer(FilterObj filterObj);

    List<FlightRoute> findWhereRoutePriceDurationTransfer(FilterObj filterObj);

    //**************************************8***************************************************

    List<FlightRoute> findWhereRouteDatePriceDuration(FilterObj filterObj);

    //**************************************9***************************************************

    List<FlightRoute> findWhereRouteDatePriceDurationName(FilterObj filterObj);

    List<FlightRoute> findWhereRouteDatePriceDurationTranfser(FilterObj filterObj);

    //**************************************10**************************************************

    List<FlightRoute> findWhereRouteDatePriceDurationTranfserName(FilterObj filterObj);
}
