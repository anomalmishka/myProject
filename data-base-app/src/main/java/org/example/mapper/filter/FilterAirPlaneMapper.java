package org.example.mapper.filter;

import org.example.dto.filter.FilterAirPlaneDTO;
import org.example.model.filter.FilterAirPlaneObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterAirPlaneMapper {

    public FilterAirPlaneDTO toDTO(FilterAirPlaneObject filterAirPlaneObject) {
        return FilterAirPlaneDTO.builder()
                .routeStart(filterAirPlaneObject.getRouteStart())
                .routeEnd(filterAirPlaneObject.getRouteEnd())
                .dateStart(filterAirPlaneObject.getDateStart())
                .dateEnd(filterAirPlaneObject.getDateEnd())
                .priceStart(filterAirPlaneObject.getPriceStart())
                .priceEnd(filterAirPlaneObject.getPriceEnd())
                .build();
    }

    public List<FilterAirPlaneDTO> toDTO(List<FilterAirPlaneObject> filterAirPlaneObjects) {
        return filterAirPlaneObjects.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FilterAirPlaneObject> toModel(List<FilterAirPlaneDTO> filterAirPlaneDTOS) {
        return filterAirPlaneDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FilterAirPlaneObject toModel(FilterAirPlaneDTO filterAirPlaneDTO) {
        return FilterAirPlaneObject.builder()
                .routeStart(filterAirPlaneDTO.getRouteStart())
                .routeEnd(filterAirPlaneDTO.getRouteEnd())
                .dateStart(filterAirPlaneDTO.getDateStart())
                .dateEnd(filterAirPlaneDTO.getDateEnd())
                .priceStart(filterAirPlaneDTO.getPriceStart())
                .priceEnd(filterAirPlaneDTO.getPriceEnd())
                .build();
    }
}
