package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_PLANE")
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NUMBER_SEAT_LOWCOST")
    private Integer numberSeatLowcost;
    @Column(name = "NUMBER_SEAT_BUISNESS")
    private Integer numberSeatBuisness;
    @Column(name = "PRICE_PER_KILOMETER")
    private Integer pricePerKilometer;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

//    @ManyToOne(
//            cascade = CascadeType.MERGE,
//            fetch = FetchType.LAZY
//    )
//    private AirCompany airCompany;

    @ManyToMany(targetEntity = FlightRoute.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "AIR_PLANE_FLIGHT_ROUTE",
            joinColumns = @JoinColumn(name = "AIR_PLANE_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLIGHT_ROUTE_ID"))
//    @ManyToMany(
//            cascade = CascadeType.MERGE,
//            fetch = FetchType.LAZY
//            ,
//            mappedBy = "airPlaneList"
//    )
    private List<FlightRoute> flightRouteList;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "AIR_PLANE_ID")
    private List<Seat> seatList;
}
