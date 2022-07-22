package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.PriceDTO;
import org.example.mapper.filter.PriceMapper;
import org.example.service.filter.api.PriceService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/price")
public class PriceController {
    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @PostMapping(path = "find/total/price/where/air/plane", produces = "application/json", consumes = "application/json")
    public PriceDTO findAllUserWhereAirPlane(@RequestBody PriceDTO priceDTO) {
        return priceMapper.toDTO(priceService.getTotalFlyPriceWhereAirPlane(priceMapper.toModel(priceDTO)));
    }
}

