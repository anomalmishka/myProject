package org.example.mapper.modelsMapper;


import org.example.dto.modelsDTO.UserDTO;
import org.example.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .sex(user.getSex())
                .phone(user.getPhone())
                .passportNumber(user.getPassportNumber())
                .email(user.getEmail())
                .age(user.getAge())
                .categoryClient(user.getCategoryClient())
                .isActiveProfile(user.getIsActiveProfile())
                .build();
    }

    public List<UserDTO> toDTO(List<User> user) {
        return user.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<User> toModel(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public User toModel(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .sex(userDTO.getSex())
                .phone(userDTO.getPhone())
                .passportNumber(userDTO.getPassportNumber())
                .email(userDTO.getEmail())
                .age(userDTO.getAge())
                .categoryClient(userDTO.getCategoryClient())
                .isActiveProfile(userDTO.getIsActiveProfile())
                .build();
    }
}
