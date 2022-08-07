package org.example.model;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne
    private AirPlane airPlane;
    public AirPlane getAirPlane(){
        return airPlane;
    }
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private FlightRoute flightRoute;
    public FlightRoute getFlightRoute(){
        return flightRoute;
    }

}