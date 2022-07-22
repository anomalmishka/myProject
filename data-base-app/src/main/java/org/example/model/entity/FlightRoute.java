package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "FLIGHT_ROUTE")
public class FlightRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROUTE_START")
    private String routeStart;
    @Column(name = "ROUTE_END")
    private String routeEnd;
    @Column(name = "DISTANCE")
    private Integer distance;
    @Column(name = "FLIGHT_DATE_START")
    private Date flightDateStart;
    @Column(name = "FLIGHT_DATE_END")
    private Date flightDateEnd;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "flightRouteList"
    )
    private List<AirPlane> airPlaneList;

    @OneToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "FLIGHT_ROUTE_ID")
    private List<UserOrder> userOrderList;
}
