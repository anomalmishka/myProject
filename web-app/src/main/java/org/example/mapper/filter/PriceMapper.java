package org.example.mapper.filter;

import org.example.dto.filter.PriceDTO;
import org.example.model.obj.filter.PriceObj;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceMapper {

    public PriceDTO toDTO(PriceObj priceObj) {
        return PriceDTO.builder()
                .idAirCompany(priceObj.getIdAirCompany())
                .idAirPlane(priceObj.getIdAirPlane())
                .idFlightRoute(priceObj.getIdFlightRoute())
                .totalPriceFlyList(priceObj.getTotalPriceFlyList())
                .priceLowcostSeat(priceObj.getPriceLowcostSeat())
                .priceBuisnessSeat(priceObj.getPriceBuisnessSeat())
                .build();
    }

    public List<PriceDTO> toDTO(List<PriceObj> priceObjList) {
        return priceObjList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PriceObj> toModel(List<PriceDTO> priceDTOList) {
        return priceDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PriceObj toModel(PriceDTO priceDTO) {
        return PriceObj.builder()
                .idAirCompany(priceDTO.getIdAirCompany())
                .idAirPlane(priceDTO.getIdAirPlane())
                .idFlightRoute(priceDTO.getIdFlightRoute())
                .totalPriceFlyList(priceDTO.getTotalPriceFlyList())
                .priceLowcostSeat(priceDTO.getPriceLowcostSeat())
                .priceBuisnessSeat(priceDTO.getPriceBuisnessSeat())
                .build();
    }
}
