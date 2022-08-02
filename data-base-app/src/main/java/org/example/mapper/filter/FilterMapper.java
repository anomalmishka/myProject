package org.example.mapper.filter;

import org.example.dto.filter.FilterDTO;
import org.example.model.filter.FilterObj;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilterMapper {

    public List<FilterObj> toModel(List<FilterDTO> filterDTOS) {
        return filterDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public FilterObj toModel(FilterDTO filterDTO) {
        System.out.println(filterDTO);
        return FilterObj.builder()
                .routeStart(filterDTO.getRouteStart())
                .routeEnd(filterDTO.getRouteEnd())
                .dateStart(filterDTO.getDateStart())
                .dateEnd(filterDTO.getDateEnd())
                .priceStart(filterDTO.getPriceStart())
                .priceEnd(filterDTO.getPriceEnd())
                .airCompanyName(filterDTO.getAirCompanyName())
                .transfers(filterDTO.getTransfers())
                .durationStart(filterDTO.getDurationStart())
                .durationEnd(filterDTO.getDurationEnd())
                .build();
    }

//    @SneakyThrows
//    private Timestamp parseStringToLong(String stringToTimestamp) {
//        if (stringToTimestamp != null) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            return new Timestamp(dateFormat.parse(stringToTimestamp).getTime());
//        }
//        return null;
//    }
}
