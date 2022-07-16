package org.example.controller.buisness;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.dto.api.UserDTOModif;
import org.example.mapper.UserMapper;
import org.example.mapper.api.UserMapperModif;
import org.example.service.api.buisness.BuisnessFilterUserService;
import org.example.service.api.buisness.BuisnessUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "buisness/filter/user")
public class BuisnessFilterUserController {
    private final BuisnessFilterUserService buisnessFilterUserService;
    private final UserMapperModif userMapperModif;
    private final UserMapper userMapper;


    @GetMapping(path = "find/user/air/plane/{id}/", produces = "application/json", consumes = "application/json")
    public List<UserDTO> findAllUserWhereAirPlane(@PathVariable("id") Long id) {
        return userMapper.toDTO(buisnessFilterUserService.findAllUserWhereAirPlane(id));
    }
}

