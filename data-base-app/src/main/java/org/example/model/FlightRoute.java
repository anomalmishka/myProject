package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp flightDateStart;
    @Column(name = "FLIGHT_DATE_END")
    private Timestamp flightDateEnd;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "FLIGHT_ROUTE_ID")
    private List<AirPlaneFlightRoute> airPlaneFlightRouteList;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "FLIGHT_ROUTE_ID")
    private List<UserOrder> userOrderList;
}