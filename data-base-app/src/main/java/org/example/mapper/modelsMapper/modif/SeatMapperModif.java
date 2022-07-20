package org.example.mapper.modelsMapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.SeatDTOModif;
import org.example.mapper.modelsMapper.TicketMapper;
import org.example.model.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SeatMapperModif {
    private final TicketMapper ticketMapper;

    public SeatDTOModif toDTO(Seat seat) {
        return SeatDTOModif.builder()
                .id(seat.getId())
                .rowSeat(seat.getRowSeat())
                .place(seat.getPlace())
                .type(seat.getType())
                .price(seat.getPrice())
                .ticketDTO(ticketMapper.toDTO(seat.getTicket()))
                .build();
    }

    public List<SeatDTOModif> toDTO(List<Seat> seatList) {
        return seatList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Seat> toModel(List<SeatDTOModif> seatDTOModifList) {
        return seatDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Seat toModel(SeatDTOModif seatDTOModif) {
        return Seat.builder()
                .id(seatDTOModif.getId())
                .rowSeat(seatDTOModif.getRowSeat())
                .place(seatDTOModif.getPlace())
                .type(seatDTOModif.getType())
                .price(seatDTOModif.getPrice())
                .ticket(ticketMapper.toModel(seatDTOModif.getTicketDTO()))
                .build();
    }
}
