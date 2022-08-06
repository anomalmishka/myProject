package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.StatusDTO;
import org.example.dto.page.StatusPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StatusMapperPage {
    private final ModelMapper modelMapper;
    public StatusDTO toDTO(StatusPage statusPage) {
        return modelMapper.map(statusPage, StatusDTO.class);
    }

    public List<StatusDTO> toDTO(List<StatusPage> statusPageList) {
        return Optional.ofNullable(statusPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<StatusPage> toPage(List<StatusDTO> statusDTOList) {
        return Optional.ofNullable(statusDTOList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public StatusPage toPage(StatusDTO statusDTO) {
        return modelMapper.map(statusDTO, StatusPage.class);
    }
}
