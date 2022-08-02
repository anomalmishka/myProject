package org.example.mapper.models;

import org.example.dto.modelsDTO.SeatDTO;
import org.example.model.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatMapper {
    public SeatDTO toDTO(Seat seat) {
        return SeatDTO.builder()
                .id(seat.getId())
                .place(seat.getPlace())
                .type(seat.getType())
                .isOrdered(seat.getIsOrdered())
                .build();
    }

    public List<SeatDTO> toDTO(List<Seat> seatList) {
        return seatList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Seat> toModel(List<SeatDTO> seatDTOList) {
        return seatDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Seat toModel(SeatDTO seatDTO) {
        return Seat.builder()
                .id(seatDTO.getId())
                .place(seatDTO.getPlace())
                .type(seatDTO.getType())
                .isOrdered(seatDTO.getIsOrdered())
                .build();
    }
}
