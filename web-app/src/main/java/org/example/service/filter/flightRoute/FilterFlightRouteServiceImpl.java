package org.example.service.filter.flightRoute;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterDTO;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.service.rest.filter.flightRoute.FlightRouteRestTemplateFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterFlightRouteServiceImpl implements FilterFlightRouteService {

    private final FlightRouteRestTemplateFilter flightRouteRestTemplateFilter;

    @Override
    public List<FlightRouteDTOModif2> findAll() {
        return flightRouteRestTemplateFilter.findAll();
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteStart(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/start");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoute(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDate(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date");
    }

    @Override
    public List<FlightRouteDTOModif2> findWherePrice(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/price");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDateName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWherePriceName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDate(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePrice(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDatePrice(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/price");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDateDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWherePriceDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/price/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDateName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePriceName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDatePriceName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDateDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWherePriceDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/price/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDateTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePriceTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDurationTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/duration/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePrice(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDateDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePriceDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDatePriceDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/price/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDateDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePriceDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price/price/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereDatePriceDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/date/price/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDateDurationTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/duration/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRoutePriceDurationTransfer(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/price/duration/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDuration(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/duration");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/duration/name");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfser(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/duration/transfer");
    }

    @Override
    public List<FlightRouteDTOModif2> findWhereRouteDatePriceDurationTranfserName(FilterDTO filterDTO) {
        return flightRouteRestTemplateFilter.exchangeFilterToFlightRoute(filterDTO,"where/route/date/price/duration/transfer/name");
    }
}
