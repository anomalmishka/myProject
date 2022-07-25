package org.example.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Seat {
    private Long id;
    private String place;
    private String type;
    private Boolean isOrdered;
    private AirPlane airPlane;
}
