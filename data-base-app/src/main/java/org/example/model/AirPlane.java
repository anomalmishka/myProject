package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_PLANE")
@Embeddable
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
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private AirCompany airCompany;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "AIR_PLANE_ID")
    private List<AirPlaneFlightRoute> airPlaneFlightRouteList;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "AIR_PLANE_ID")
    private List<Seat> seatList;
}