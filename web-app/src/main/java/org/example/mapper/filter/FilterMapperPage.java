package org.example.mapper.filter;

import lombok.SneakyThrows;
import org.example.dto.FilterObj;
import org.example.dto.page.filterPage.FilterPage;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class FilterMapperPage {
    public FilterObj toOBJ(FilterPage filterPage) {
        Boolean routeStartCheckbox = filterPage.getRouteStartCheckbox() != null;
        Boolean routeEndCheckbox = filterPage.getRouteEndCheckbox() != null;
        Boolean dateStartCheckbox = filterPage.getDateStartCheckbox() != null;
        Boolean dateEndCheckbox = filterPage.getDateEndCheckbox() != null;
        Boolean priceStartCheckbox = filterPage.getPriceStartCheckbox() != null;
        Boolean airCompanyNameCheckbox = filterPage.getAirCompanyNameCheckbox() != null;
        Boolean transfersCheckbox = filterPage.getTransfersCheckbox() != null;
        Boolean flightDurationCheckbox = filterPage.getFlightDurationCheckbox() != null;
        return FilterObj.builder()
                .routeStart(filterPage.getRouteStart())
                .routeEnd(filterPage.getRouteEnd())
                .dateStart(parseStringToLong(filterPage.getDateStart()))
                .dateEnd(parseStringToLong(filterPage.getDateEnd()))
                .priceStart(0)
                .priceEnd(Integer.parseInt(filterPage.getPriceEnd()))
                .airCompanyName(filterPage.getAirCompanyName())
                .transfers(filterPage.getTransfers())
                .durationStart(0)
                .durationEnd(Integer.parseInt(filterPage.getDurationEnd())*60)
                .routeStartCheckbox(routeStartCheckbox)
                .routeEndCheckbox(routeEndCheckbox)
                .dateStartCheckbox(dateStartCheckbox)
                .dateEndCheckbox(dateEndCheckbox)
                .priceStartCheckbox(priceStartCheckbox)
                .airCompanyNameCheckbox(airCompanyNameCheckbox)
                .transfersCheckbox(transfersCheckbox)
                .flightDurationCheckbox(flightDurationCheckbox)
                .build();
    }

    @SneakyThrows
    private Timestamp parseStringToLong(String stringToTimestamp) {
        if (stringToTimestamp != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return new Timestamp(dateFormat.parse(stringToTimestamp).getTime());
        }
        return null;
    }
}
