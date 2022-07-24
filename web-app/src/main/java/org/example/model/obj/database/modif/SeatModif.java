package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.AirPlane;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatModif {
    private Long id;
    private String place;
    private String type;
    private Boolean isOrdered;
    private AirPlane airPlane;
}
