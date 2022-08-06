package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.model.PassengerProfile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperModif {
    private final ModelMapper modelMapper;

    public PassengerProfileDTOModif toDTO(PassengerProfile passengerProfile) {
        return modelMapper.map(passengerProfile, PassengerProfileDTOModif.class);
    }

    public List<PassengerProfileDTOModif> toDTO(List<PassengerProfile> passengerProfileList) {
        return Optional.ofNullable(passengerProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOModif> passengerProfileDTOModifList) {
        return Optional.ofNullable(passengerProfileDTOModifList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfile toModel(PassengerProfileDTOModif passengerProfileDTOModif) {
        return modelMapper.map(passengerProfileDTOModif, PassengerProfile.class);
    }
}
