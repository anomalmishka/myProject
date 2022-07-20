package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.PassengerProfileDTO;
import org.example.mapper.modelsMapper.PassengerProfileMapper;
import org.example.service.filter.api.FilterPassengerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/passenger")
public class FilterUserController {
    private final FilterPassengerProfileService filterPassengerProfileService;
    private final PassengerProfileMapper passengerProfileMapper;

    @GetMapping(path = "find/passenger/air/plane/{id}/", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTO> findAllUserWhereAirPlane(@PathVariable("id") Long id) {
        return passengerProfileMapper.toDTO(filterPassengerProfileService.findAllPassengerProfileWhereAirPlane(id));
    }
    @GetMapping(path = "find/passenger/air/company/{id}/", produces = "application/json", consumes = "application/json")
    public List<PassengerProfileDTO> findAllUserWhereAirCompany(@PathVariable("id") Long id) {
        return passengerProfileMapper.toDTO(filterPassengerProfileService.findAllPassengerProfileWhereAirCompany(id));
    }
}

