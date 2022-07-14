package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDTO {
    private Long id;
    private Integer passengerSeat;
    private Integer ticketPrice;
    private Boolean isEmptySeat;
    private Boolean isActive;
}