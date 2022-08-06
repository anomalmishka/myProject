package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_PLANE_FLIGHT_ROUTE")
public class AirPlaneFlightRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    private AirPlane airPlane;

//    public AirPlane getAirPlane() {
//        return airPlane;
//    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private FlightRoute flightRoute;

//    public FlightRoute getFlightRoute() {
//        return flightRoute;
//    }
}