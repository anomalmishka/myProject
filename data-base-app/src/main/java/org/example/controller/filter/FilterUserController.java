package org.example.controller.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.UserDTO;
import org.example.mapper.modelsMapper.UserMapper;
import org.example.service.filter.api.FilterUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user")
public class FilterUserController {
    private final FilterUserService filterUserService;
    private final UserMapper userMapper;

    @GetMapping(path = "find/user/air/plane/{id}/", produces = "application/json", consumes = "application/json")
    public List<UserDTO> findAllUserWhereAirPlane(@PathVariable("id") Long id) {
        return userMapper.toDTO(filterUserService.findAllUserWhereAirPlane(id));
    }
    @GetMapping(path = "find/user/air/company/{id}/", produces = "application/json", consumes = "application/json")
    public List<UserDTO> findAllUserWhereAirCompany(@PathVariable("id") Long id) {
        return userMapper.toDTO(filterUserService.findAllUserWhereAirCompany(id));
    }
}

