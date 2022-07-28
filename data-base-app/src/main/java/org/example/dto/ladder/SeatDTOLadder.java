package org.example.dto.ladder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatDTOLadder {
    private Long id;
    private String place;
    private String type;
    private Boolean isOrdered;
}
