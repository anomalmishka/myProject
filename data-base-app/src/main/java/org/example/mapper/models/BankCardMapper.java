package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.model.BankCard;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class BankCardMapper {
    private final ModelMapper modelMapper;

    public BankCardDTO toDTO(BankCard bankCard) {
        return modelMapper.map(bankCard, BankCardDTO.class);

    }

    public List<BankCardDTO> toDTO(List<BankCard> bankCardList) {
        return Optional.ofNullable(bankCardList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }
    public List<BankCard> toModel(List<BankCardDTO> bankCardDTOList) {
        return Optional.ofNullable(bankCardDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public BankCard toModel(BankCardDTO bankCardDTO) {
        return modelMapper.map(bankCardDTO, BankCard.class);
    }
}
