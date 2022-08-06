package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.AirCompanyDTO;
import org.example.model.AirCompany;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AirCompanyMapper {
    private final ModelMapper modelMapper;
    public AirCompanyDTO toDTO(AirCompany airCompany) {
        return modelMapper.map(airCompany, AirCompanyDTO.class);
    }

    public List<AirCompanyDTO> toDTO(List<AirCompany> airCompanyList) {
        return Optional.ofNullable(airCompanyList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirCompany> toModel(List<AirCompanyDTO> airCompanyDTOList) {
        return Optional.ofNullable(airCompanyDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public AirCompany toModel(AirCompanyDTO airCompanyDTO) {
        return modelMapper.map(airCompanyDTO, AirCompany.class);
    }
}
