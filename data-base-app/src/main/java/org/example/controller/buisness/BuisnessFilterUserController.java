package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.UserDTO;
import org.example.mapper.modelsMapper.UserMapper;
import org.example.service.interfaces.buisness.BuisnessFilterUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user")
public class BuisnessFilterUserController {
    private final BuisnessFilterUserService buisnessFilterUserService;
    private final UserMapper userMapper;

    @GetMapping(path = "find/user/air/plane/{id}/", produces = "application/json", consumes = "application/json")
    public List<UserDTO> findAllUserWhereAirPlane(@PathVariable("id") Long id) {
        return userMapper.toDTO(buisnessFilterUserService.findAllUserWhereAirPlane(id));
    }
    @GetMapping(path = "find/user/air/company/{id}/", produces = "application/json", consumes = "application/json")
    public List<UserDTO> findAllUserWhereAirCompany(@PathVariable("id") Long id) {
        return userMapper.toDTO(buisnessFilterUserService.findAllUserWhereAirCompany(id));
    }
}

