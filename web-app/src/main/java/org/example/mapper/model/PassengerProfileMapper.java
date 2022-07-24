package org.example.mapper.model;

import org.example.dto.models.PassengerProfileDTO;
import org.example.model.obj.database.model.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerProfileMapper {
    public PassengerProfileDTO toDTO(PassengerProfile passengerProfile) {
        return PassengerProfileDTO.builder()
                .id(passengerProfile.getId())
                .name(passengerProfile.getName())
                .lastname(passengerProfile.getLastname())
                .passportNumber(passengerProfile.getPassportNumber())
                .build();
    }

    public List<PassengerProfileDTO> toDTO(List<PassengerProfile> passengerProfileList) {
        return passengerProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTO> passengerProfileDTOList) {
        return passengerProfileDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PassengerProfile toModel(PassengerProfileDTO passengerProfileDTO) {
        return PassengerProfile.builder()
                .id(passengerProfileDTO.getId())
                .name(passengerProfileDTO.getName())
                .lastname(passengerProfileDTO.getLastname())
                .passportNumber(passengerProfileDTO.getPassportNumber())
                .build();
    }
}
