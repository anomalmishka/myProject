package org.example.mapper.api;

import org.example.dto.api.UserDTOModif;
import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperModif {
    public UserDTOModif toDTO(User user) {
        return UserDTOModif.builder()
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
                .bankCards(user.getBankCards())
                .tickets(user.getTickets())
                .build();
    }

    public List<UserDTOModif> toDTO(List<User> user) {
        return user.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<User> toModel(List<UserDTOModif> userDTOModifs) {
        return userDTOModifs.stream().map(this::toModel).collect(Collectors.toList());
    }

    public User toModel(UserDTOModif userDTOModif) {
        return User.builder()
                .id(userDTOModif.getId())
                .name(userDTOModif.getName())
                .lastname(userDTOModif.getLastname())
                .sex(userDTOModif.getSex())
                .phone(userDTOModif.getPhone())
                .passportNumber(userDTOModif.getPassportNumber())
                .email(userDTOModif.getEmail())
                .age(userDTOModif.getAge())
                .categoryClient(userDTOModif.getCategoryClient())
                .isActiveProfile(userDTOModif.getIsActiveProfile())
                .bankCards(userDTOModif.getBankCards())
                .tickets(userDTOModif.getTickets())
                .build();
    }
}
