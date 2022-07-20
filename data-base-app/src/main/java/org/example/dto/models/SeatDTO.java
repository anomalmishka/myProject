package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatDTO {
    private Long id;
    private Integer rowSeat;
    private Integer place;
    private String type;
    private Integer price;
}
