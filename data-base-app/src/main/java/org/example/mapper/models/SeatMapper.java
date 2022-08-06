package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.SeatDTO;
import org.example.model.Seat;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SeatMapper {

    private final ModelMapper modelMapper;

    public SeatDTO toDTO(Seat seat) {
        return modelMapper.map(seat, SeatDTO.class);
    }

    public List<SeatDTO> toDTO(List<Seat> seatList) {
        return Optional.ofNullable(seatList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<Seat> toModel(List<SeatDTO> seatDTOList) {
        return Optional.ofNullable(seatDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public Seat toModel(SeatDTO seatDTO) {
        return modelMapper.map(seatDTO, Seat.class);
    }
}
