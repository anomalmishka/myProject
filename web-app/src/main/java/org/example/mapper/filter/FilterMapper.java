package org.example.mapper.filter;

import org.example.dto.filter.FilterDTO;
import org.example.model.obj.filter.FilterObj;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapper {

//    public FilterDTO toDTO(FilterObj filterObj) {
//        return FilterDTO.builder()
//                .routeStart(filterObj.getRouteStart())
//                .routeEnd(filterObj.getRouteEnd())
//                .dateStart(filterObj.getDateStart())
//                .dateEnd(filterObj.getDateEnd())
//                .priceStart(filterObj.getPriceStart())
//                .priceEnd(filterObj.getPriceEnd())
//                .build();
//    }
//
//    public List<FilterDTO> toDTO(List<FilterObj> filterObjs) {
//        return filterObjs.stream().map(this::toDTO).collect(Collectors.toList());
//    }

    public List<FilterObj> toModel(List<FilterDTO> filterDTOS) {
        return filterDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

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
