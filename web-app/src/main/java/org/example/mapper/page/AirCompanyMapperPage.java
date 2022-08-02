package org.example.mapper.page;

import org.example.dto.modelsDTO.AirCompanyDTO;
import org.example.dto.page.modelPage.AirCompanyPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AirCompanyMapperPage {
    public AirCompanyDTO toDTO(AirCompanyPage airCompanyDTO) {
        return AirCompanyDTO.builder()
                .id(airCompanyDTO.getId())
                .nameCompany(airCompanyDTO.getNameCompany())
                .countryLocation(airCompanyDTO.getCountryLocation())
                .build();
    }

    public List<AirCompanyDTO> toDTO(List<AirCompanyPage> airCompanyDTOList) {
        return Optional.ofNullable(airCompanyDTOList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<AirCompanyPage> toPage(List<AirCompanyDTO> airCompanyDTOList) {
        return Optional.ofNullable(airCompanyDTOList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public AirCompanyPage toPage(AirCompanyDTO airCompanyDTO) {
        return AirCompanyPage.builder()
                .id(airCompanyDTO.getId())
                .nameCompany(airCompanyDTO.getNameCompany())
                .countryLocation(airCompanyDTO.getCountryLocation())
                .build();
    }
}
