package org.example.mapper.page;

import org.example.dto.modelsDTO.StatusDTO;
import org.example.dto.page.modelPage.StatusPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StatusMapperPage {
    public StatusDTO toDTO(StatusPage statusPage) {
        return StatusDTO.builder()
                .id(statusPage.getId())
                .status(statusPage.getStatus())
                .build();
    }

    public List<StatusDTO> toDTO(List<StatusPage> statusPageList) {
        return Optional.ofNullable(statusPageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<StatusPage> toPage(List<StatusDTO> statusDTOList) {
        return Optional.ofNullable(statusDTOList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public StatusPage toPage(StatusDTO statusDTO) {
        return StatusPage.builder()
                .id(statusDTO.getId())
                .status(statusDTO.getStatus())
                .build();
    }
}
