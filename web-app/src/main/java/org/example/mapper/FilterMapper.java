package org.example.mapper;

import org.example.dto.filter.FilterAirPlaneDTO;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapper {

    public FilterAirPlaneDTO toDTO(FilterObj filterObj) {
        return FilterAirPlaneDTO.builder()
                .routeStart(filterObj.getRouteStart())
                .routeEnd(filterObj.getRouteEnd())
                .dateStart(filterObj.getDateStart())
                .dateEnd(filterObj.getDateEnd())
                .priceStart(filterObj.getPriceStart())
                .priceEnd(filterObj.getPriceEnd())
                .build();
    }

    public List<FilterAirPlaneDTO> toDTO(List<FilterObj> filterObjList) {
        return filterObjList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FilterObj> toModel(List<FilterAirPlaneDTO> filterAirPlaneDTOList) {
        return filterAirPlaneDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FilterObj toModel(FilterAirPlaneDTO filterAirPlaneDTO) {
        return FilterObj.builder()
                .routeStart(filterAirPlaneDTO.getRouteStart())
                .routeEnd(filterAirPlaneDTO.getRouteEnd())
                .dateStart(filterAirPlaneDTO.getDateStart())
                .dateEnd(filterAirPlaneDTO.getDateEnd())
                .priceStart(filterAirPlaneDTO.getPriceStart())
                .priceEnd(filterAirPlaneDTO.getPriceEnd())
                .build();
    }
}
