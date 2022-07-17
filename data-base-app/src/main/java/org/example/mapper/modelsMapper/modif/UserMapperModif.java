package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.modelsDTO.modif.UserDTOModif;
import org.example.mapper.modelsMapper.BankCardMapper;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.model.entity.BankCard;
import org.example.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class UserMapperModif {
    private final TicketMapper ticketMapper;
    private final BankCardMapper bankCardMapper;
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
                .bankCardDTOS(bankCardMapper.toDTO(user.getBankCards()))
                .ticketDTOS(ticketMapper.toDTO(user.getTickets()))
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
                .bankCards(bankCardMapper.toModel(userDTOModif.getBankCardDTOS()))
                .tickets(ticketMapper.toModel(userDTOModif.getTicketDTOS()))
                .build();
    }
}
