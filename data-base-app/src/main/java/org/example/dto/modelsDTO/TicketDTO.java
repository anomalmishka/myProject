package org.example.dto.modelsDTO;

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
    private Boolean isEmptySeat;
    private Boolean isActive;
}
