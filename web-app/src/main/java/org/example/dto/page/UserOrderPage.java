package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderPage {
    private Long idUserOrder;

    private Long idStatus;
    private String statusStatus;

    private Long idFlightRoute;
    private String routeStartFlightRoute;
    private String routeEndFlightRoute;
    private Integer distanceFlightRoute;
    private Date flightDateStartFlightRoute;
    private Date flightDateEndFlightRoute;
    private Boolean isActiveFlightRoute;

    private Long idPassengerProfile;
    private String namePassengerProfile;
    private String lastnamePassengerProfile;
    private String passportNumberPassengerProfile;
}
