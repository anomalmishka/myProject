package org.example.mapper.modelsMapper;


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
                .cardType(bankCard.getCardType())
                .bank(bankCard.getBank())
                .holderName(bankCard.getHolderName())
                .holderLastname(bankCard.getHolderLastname())
                .cardNumber(bankCard.getCardNumber())
                .serviceEndDate(bankCard.getServiceEndDate())
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
                .cardType(bankCardDTO.getCardType())
                .bank(bankCardDTO.getBank())
                .holderName(bankCardDTO.getHolderName())
                .holderLastname(bankCardDTO.getHolderLastname())
                .cardNumber(bankCardDTO.getCardNumber())
                .serviceEndDate(bankCardDTO.getServiceEndDate())
                .build();
    }
}