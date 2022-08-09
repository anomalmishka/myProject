package org.example.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @JoinColumn(name = "AIR_COMPANY_ID")
    private AirCompany airCompany;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(
            cascade = CascadeType.MERGE,
            mappedBy = "airPlane"
    )
    private List<AirPlaneFlightRoute> airPlaneFlightRouteList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "airPlane"
    )
    private List<Seat> seatList;
}