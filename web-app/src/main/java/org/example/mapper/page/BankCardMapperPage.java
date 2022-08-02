package org.example.mapper.page;

import org.example.dto.modelsDTO.BankCardDTO;
import org.example.dto.page.modelPage.BankCardPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BankCardMapperPage {
    public BankCardDTO toDTO(BankCardPage bankCardPage) {
        return BankCardDTO.builder()
                .id(bankCardPage.getId())
                .cardNumber(bankCardPage.getCardNumber())
                .build();
    }

    public List<BankCardDTO> toDTO(List<BankCardPage> bankCardPageList) {
        return Optional.ofNullable(bankCardPageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }
    public List<BankCardPage> toPage(List<BankCardDTO> bankCardDTOList) {
        return Optional.ofNullable(bankCardDTOList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public BankCardPage toPage(BankCardDTO bankCardDTO) {
        return BankCardPage.builder()
                .id(bankCardDTO.getId())
                .cardNumber(bankCardDTO.getCardNumber())
                .build();
    }
}
