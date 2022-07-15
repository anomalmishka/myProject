package org.example.mapper;

import org.example.dto.FilterDTO;
import org.example.dto.api.FilterObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapper {

    public FilterDTO toDTO(FilterObject filterObject) {
        return FilterDTO.builder()
                .routeStart(filterObject.getRouteStart())
                .routeEnd(filterObject.getRouteEnd())
                .dateStart(filterObject.getDateStart())
                .dateEnd(filterObject.getDateEnd())
                .priceStart(filterObject.getPriceStart())
                .priceEnd(filterObject.getPriceEnd())
                .build();
    }

    public List<FilterDTO> toDTO(List<FilterObject> filterObjects) {
        return filterObjects.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FilterObject> toModel(List<FilterDTO> filterDTOS) {
        return filterDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FilterObject toModel(FilterDTO filterDTO) {
        return FilterObject.builder()
                .routeStart(filterDTO.getRouteStart())
                .routeEnd(filterDTO.getRouteEnd())
                .dateStart(filterDTO.getDateStart())
                .dateEnd(filterDTO.getDateEnd())
                .priceStart(filterDTO.getPriceStart())
                .priceEnd(filterDTO.getPriceEnd())
                .build();
    }
}
