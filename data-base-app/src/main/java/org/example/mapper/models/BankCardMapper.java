package org.example.mapper.models;

import org.example.dto.modelsDTO.BankCardDTO;
import org.example.model.entity.BankCard;
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

    public List<BankCardDTO> toDTO(List<BankCard> bankCardList) {
        return bankCardList.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<BankCard> toModel(List<BankCardDTO> bankCardDTOList) {
        return bankCardDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public BankCard toModel(BankCardDTO bankCardDTO) {
        return BankCard.builder()
                .id(bankCardDTO.getId())
                .cardNumber(bankCardDTO.getCardNumber())
                .build();
    }
}
