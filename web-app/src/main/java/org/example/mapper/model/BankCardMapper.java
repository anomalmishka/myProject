package org.example.mapper.model;

import org.example.dto.models.BankCardDTO;
import org.example.model.database.BankCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankCardMapper {
    public BankCardDTO toDTO(BankCard bankCard) {
        return BankCardDTO.builder()
                .id(bankCard.getId())
                .cardNumber(bankCard.getCardNumber())
                .build();
    }

    public List<BankCardDTO> toDTO(List<BankCard> bankCards) {
        return bankCards.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<BankCard> toModel(List<BankCardDTO> bankCardDTOS) {
        return bankCardDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }

    public BankCard toModel(BankCardDTO bankCardDTO) {
        return BankCard.builder()
                .id(bankCardDTO.getId())
                .cardNumber(bankCardDTO.getCardNumber())
                .build();
    }
}
