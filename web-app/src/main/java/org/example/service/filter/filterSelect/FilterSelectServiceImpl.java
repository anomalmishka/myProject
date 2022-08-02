package org.example.service.filter.filterSelect;

import lombok.RequiredArgsConstructor;
import org.example.dto.FilterObj;
import org.example.dto.modelsDTO.modif2.FlightRouteDTOModif2;
import org.example.mapper.filter.FilterMapperDTO;
import org.example.service.filter.flightRoute.FilterFlightRouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilterSelectServiceImpl implements FilterSelectService {
    private final FilterFlightRouteService filterFlightRouteService;
    private final FilterMapperDTO filterMapperDTO;

    @Override
    public List<FlightRouteDTOModif2> filterSelect(FilterObj filterObj) {
        //**************************************1***************************************************
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereRouteStart(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************2***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereRoute(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereDate(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWherePrice(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereDuration(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************3***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereRouteName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereDateName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWherePriceName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteTransfer(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************4***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDate(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePrice(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDuration(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereDatePrice(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereDateDuration(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWherePriceDuration(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************5***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDateName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePriceName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereDatePriceName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())

        ) {
            return filterFlightRouteService.findWhereDateDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWherePriceDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDateTransfer(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePriceTransfer(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDurationTransfer(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************6***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePrice(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDateDuration(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePriceDuration(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereDatePriceDuration(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************7***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDateDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePriceDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (!filterObj.getRouteStartCheckbox()) &&
                        (!filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereDatePriceDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (!filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceTransfer(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (!filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDateDurationTransfer(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (!filterObj.getDateStartCheckbox()) &&
                        (!filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRoutePriceDurationTransfer(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************8***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceDuration(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************9***************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (!filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceDurationName(filterMapperDTO.toDTO(filterObj));
        }
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (!filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceDurationTranfser(filterMapperDTO.toDTO(filterObj));
        }
        //**************************************10**************************************************
        if (
                (filterObj.getRouteStartCheckbox()) &&
                        (filterObj.getRouteEndCheckbox()) &&
                        (filterObj.getDateStartCheckbox()) &&
                        (filterObj.getDateEndCheckbox()) &&
                        (filterObj.getPriceStartCheckbox()) &&
                        (filterObj.getAirCompanyNameCheckbox()) &&
                        (filterObj.getTransfersCheckbox()) &&
                        (filterObj.getFlightDurationCheckbox())
        ) {
            return filterFlightRouteService.findWhereRouteDatePriceDurationTranfserName(filterMapperDTO.toDTO(filterObj));
        }
        return filterFlightRouteService.findAll();
    }
}
