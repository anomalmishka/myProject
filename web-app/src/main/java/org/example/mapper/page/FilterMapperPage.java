package org.example.mapper.page;

import org.example.dto.page.filter.FilterPage;
import org.example.model.Filter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapperPage {
    private static final String PATTERN_FORMAT = "yyyy-MM-dd";

    public List<Filter> toModel(List<FilterPage> filterPageList) {
        return filterPageList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Filter toModel(FilterPage filterPage) {
        SimpleDateFormat format = new SimpleDateFormat(PATTERN_FORMAT);
        try {
            Date parsedDateStart = format.parse(filterPage.getDateStart());
            Date parsedDateEnd = format.parse(filterPage.getDateEnd());
            return Filter.builder()
                    .routeStart(filterPage.getRouteStart())
                    .routeEnd(filterPage.getRouteEnd())
                    .dateStart(parsedDateStart)
                    .dateEnd(parsedDateEnd)
                    .priceStart(0)
                    .priceEnd(Integer.valueOf(filterPage.getPriceEnd()))
                    .airCompany(filterPage.getAirCompany())
                    .transfers(filterPage.getTransfers())
                    .durationStart(0)
                    .durationEnd(Integer.valueOf(filterPage.getDurationEnd()))
                    .routeStartCheckbox(filterPage.getRouteStartCheckbox() != null)
                    .routeEndCheckbox(filterPage.getRouteEndCheckbox() != null)
                    .dateStartCheckbox(filterPage.getDateStartCheckbox() != null)
                    .dateEndCheckbox(filterPage.getDateEndCheckbox() != null)
                    .priceStartCheckbox(filterPage.getPriceStartCheckbox() != null)
                    .airCompanyCheckbox(filterPage.getAirCompanyCheckbox() != null)
                    .transfersCheckbox(filterPage.getTransfersCheckbox() != null)
                    .flightDurationCheckbox(filterPage.getFlightDurationCheckbox() != null)
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
