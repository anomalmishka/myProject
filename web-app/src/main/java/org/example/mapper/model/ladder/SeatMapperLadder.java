package org.example.mapper.model.ladder;

import org.example.dto.ladder.SeatDTOLadder;
import org.example.model.database.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatMapperLadder {
    public SeatDTOLadder toDTO(Seat seat) {
        return SeatDTOLadder.builder()
                .id(seat.getId())
                .place(seat.getPlace())
                .type(seat.getType())
                .isOrdered(seat.getIsOrdered())
                .build();
    }

    public List<SeatDTOLadder> toDTO(List<Seat> seatList) {
        return seatList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Seat> toModel(List<SeatDTOLadder> seatDTOLadderList) {
        return seatDTOLadderList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Seat toModel(SeatDTOLadder seatDTOLadder) {
        return Seat.builder()
                .id(seatDTOLadder.getId())
                .place(seatDTOLadder.getPlace())
                .type(seatDTOLadder.getType())
                .isOrdered(seatDTOLadder.getIsOrdered())
                .build();
    }
}
