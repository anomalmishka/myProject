package org.example.mapper;

import org.example.dto.filter.FilterDTO;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Component;

@Component
public class FilterMapper {
    public FilterObj toModel(FilterDTO filterDTO) {
        return FilterObj.builder()
                .routeStart(filterDTO.getRouteStart())
                .routeEnd(filterDTO.getRouteEnd())
                .dateStart(filterDTO.getDateStart())
                .dateEnd(filterDTO.getDateEnd())
                .priceStart(filterDTO.getPriceStart())
                .priceEnd(filterDTO.getPriceEnd())
                .build();
    }
}
