package org.example.mapper.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.PriceDTO;
import org.example.mapper.models.AirCompanyMapper;
import org.example.mapper.models.AirPlaneMapper;
import org.example.mapper.models.FlightRouteMapper;
import org.example.model.filter.PriceObj;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class PriceMapper {
    private final AirCompanyMapper airCompanyMapper;
    private final AirPlaneMapper airPlaneMapper;
    private final FlightRouteMapper flightRouteMapper;

    public PriceDTO toDTO(PriceObj priceObj) {
        return PriceDTO.builder()
                .idAirCompany(priceObj.getIdAirCompany())
                .idAirPlane(priceObj.getIdAirPlane())
                .idFlightRoute(priceObj.getIdFlightRoute())
                .totalPriceFlyList(priceObj.getTotalPriceFlyList())
                .airCompanyDTOList(airCompanyMapper.toDTO(priceObj.getAirCompanyList()))
                .airPlaneDTOList(airPlaneMapper.toDTO(priceObj.getAirPlaneList()))
                .flightRouteDTOList(flightRouteMapper.toDTO(priceObj.getFlightRouteList()))
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
                .airCompanyList(airCompanyMapper.toModel(priceDTO.getAirCompanyDTOList()))
                .airPlaneList(airPlaneMapper.toModel(priceDTO.getAirPlaneDTOList()))
                .flightRouteList(flightRouteMapper.toModel(priceDTO.getFlightRouteDTOList()))
                .build();
    }
}
