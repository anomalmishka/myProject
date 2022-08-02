package org.example.mapper.filter;

import org.example.dto.FilterDTO;
import org.example.dto.FilterObj;
import org.springframework.stereotype.Component;

@Component
public class FilterMapperDTO {
    public FilterDTO toDTO(FilterObj filterObj) {
        return FilterDTO.builder()
                .routeStart(filterObj.getRouteStart())
                .routeEnd(filterObj.getRouteEnd())
                .dateStart(filterObj.getDateStart())
                .dateEnd(filterObj.getDateEnd())
                .priceStart(0)
                .priceEnd(filterObj.getPriceEnd())
                .airCompanyName(filterObj.getAirCompanyName())
                .transfers(filterObj.getTransfers())
                .durationStart(0)
                .durationEnd(filterObj.getDurationEnd())
                .build();
    }
}
