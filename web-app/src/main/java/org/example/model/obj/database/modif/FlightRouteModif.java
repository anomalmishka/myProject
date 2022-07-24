package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.AirPlane;
import org.example.model.obj.database.model.UserOrder;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightRouteModif {
    private Long id;
    private String routeStart;
    private String routeEnd;
    private Integer distance;
    private Date flightDateStart;
    private Date flightDateEnd;
    private Boolean isActive;
    private List<AirPlane> airPlaneList;
    private List<UserOrder> userOrderList;
}
