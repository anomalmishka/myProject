package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.dto.page.PassengerProfilePage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperPage {
    private final ModelMapper modelMapper;


    public PassengerProfileDTOModif toDTO(PassengerProfilePage passengerProfilePage) {
        return modelMapper.map(passengerProfilePage, PassengerProfileDTOModif.class);
    }

    public List<PassengerProfileDTOModif> toDTO(List<PassengerProfilePage> passengerProfilePageList) {
        return Optional.ofNullable(passengerProfilePageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfilePage> toPage(List<PassengerProfileDTOModif> passengerProfileDTOModifList) {
        return Optional.ofNullable(passengerProfileDTOModifList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfilePage toPage(PassengerProfileDTOModif passengerProfileDTOModif) {
        return modelMapper.map(passengerProfileDTOModif, PassengerProfilePage.class);
    }
}
