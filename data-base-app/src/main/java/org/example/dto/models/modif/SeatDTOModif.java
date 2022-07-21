package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.TicketDTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatDTOModif {
    private Long id;
    private Integer rowSeat;
    private Integer place;
    private String type;
    private TicketDTO ticketDTO;
}
