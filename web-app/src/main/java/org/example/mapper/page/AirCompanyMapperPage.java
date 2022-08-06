package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.dto.page.AirCompanyPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirCompanyMapperPage {
    private final ModelMapper modelMapper;
    public AirCompanyDTO toDTO(AirCompanyPage airCompanyDTO) {
        return modelMapper.map(airCompanyDTO, AirCompanyDTO.class);
    }

    public List<AirCompanyDTO> toDTO(List<AirCompanyPage> airCompanyDTOList) {
        return Optional.ofNullable(airCompanyDTOList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirCompanyPage> toPage(List<AirCompanyDTO> airCompanyDTOList) {
        return Optional.ofNullable(airCompanyDTOList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public AirCompanyPage toPage(AirCompanyDTO airCompanyDTO) {
        return modelMapper.map(airCompanyDTO, AirCompanyPage.class);
    }
}
