package org.example.mapper;

import org.example.dto.FilterDTO;
import org.example.model.Filter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapper {

    public FilterDTO toDTO(Filter filter) {
        return FilterDTO.builder()
                .routeStart(filter.getRouteStart())
                .routeEnd(filter.getRouteEnd())
                .dateStart(filter.getDateStart())
                .dateEnd(filter.getDateEnd())
                .priceStart(filter.getPriceStart())
                .priceEnd(filter.getPriceEnd())
                .build();
    }

    public List<FilterDTO> toDTO(List<Filter> filterList) {
        return filterList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
