package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.page.BankCardPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class BankCardMapperPage {
    private final ModelMapper modelMapper;
    public BankCardDTO toDTO(BankCardPage bankCardPage) {
        return modelMapper.map(bankCardPage, BankCardDTO.class);
    }

    public List<BankCardDTO> toDTO(List<BankCardPage> bankCardPageList) {
        return Optional.ofNullable(bankCardPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<BankCardPage> toPage(List<BankCardDTO> bankCardDTOList) {
        return Optional.ofNullable(bankCardDTOList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public BankCardPage toPage(BankCardDTO bankCardDTO) {
        return modelMapper.map(bankCardDTO, BankCardPage.class);
    }
}
