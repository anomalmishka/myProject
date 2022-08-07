package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.PassengerProfileDTO;
import org.example.model.PassengerProfile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapper {
    private final ModelMapper modelMapper;

    public PassengerProfileDTO toDTO(PassengerProfile passengerProfile) {
        return modelMapper.map(passengerProfile, PassengerProfileDTO.class);
    }

    public List<PassengerProfileDTO> toDTO(List<PassengerProfile> passengerProfileList) {
        return Optional.ofNullable(passengerProfileList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTO> passengerProfileDTOList) {
        return Optional.ofNullable(passengerProfileDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public PassengerProfile toModel(PassengerProfileDTO passengerProfileDTO) {
        return modelMapper.map(passengerProfileDTO, PassengerProfile.class);
    }
}
