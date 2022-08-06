package org.example.mapper.filter;

import lombok.SneakyThrows;
import org.example.dto.filter.FilterDTO;
import org.example.dto.filter.FilterPage;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class FilterMapper {

    public FilterDTO toDTO(FilterPage filterPage) {
        return FilterDTO.builder()
                .routeStart(filterPage.getRouteStartCheckbox() != null ? filterPage.getRouteStart() : null)
                .routeEnd(filterPage.getRouteEndCheckbox() != null ? filterPage.getRouteEnd() : null)
                .dateStart(filterPage.getDateStartCheckbox() != null ? parseStringToLong(filterPage.getDateStart()) : null)
                .dateEnd(filterPage.getDateEndCheckbox() != null ? parseStringToLong(filterPage.getDateEnd()) : null)
                .price(filterPage.getPriceCheckbox() != null ? Integer.parseInt(filterPage.getPrice()) : null)
                .airCompanyName(filterPage.getAirCompanyNameCheckbox() != null ? filterPage.getAirCompanyName() : null)
                .transfer(filterPage.getTransferCheckbox() != null ? filterPage.getTransfer() : null)
                .duration(filterPage.getDurationCheckbox() != null ? Integer.parseInt(filterPage.getDuration()) : null)
                .build();
    }
    @SneakyThrows
    private Timestamp parseStringToLong(String stringToTimestamp) {
        if (stringToTimestamp != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd hh:mm:ss
            return new Timestamp(dateFormat.parse(stringToTimestamp).getTime());
        }
        return null;
    }
}
