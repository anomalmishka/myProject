package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.PassengerProfileDTOModif;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.model.entity.PassengerProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PassengerProfileMapperModif {
    private final TicketMapper ticketMapperModif;

    public PassengerProfileDTOModif toDTO(PassengerProfile passengerProfile) {
        return PassengerProfileDTOModif.builder()
                .id(passengerProfile.getId())
                .name(passengerProfile.getName())
                .lastname(passengerProfile.getLastname())
                .passportNumber(passengerProfile.getPassportNumber())
                .ticketDTO(ticketMapperModif.toDTO(passengerProfile.getTicket()))
                .build();
    }

    public List<PassengerProfileDTOModif> toDTO(List<PassengerProfile> passengerProfileList) {
        return passengerProfileList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<PassengerProfile> toModel(List<PassengerProfileDTOModif> passengerProfileDTOModifList) {
        return passengerProfileDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PassengerProfile toModel(PassengerProfileDTOModif passengerProfileDTOModif) {
        return PassengerProfile.builder()
                .id(passengerProfileDTOModif.getId())
                .name(passengerProfileDTOModif.getName())
                .lastname(passengerProfileDTOModif.getLastname())
                .passportNumber(passengerProfileDTOModif.getPassportNumber())
                .ticket(ticketMapperModif.toModel(passengerProfileDTOModif.getTicketDTO()))
                .build();
    }
}
