package org.example.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PLACE")
    private String place;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "IS_ORDERED")
    private Boolean isOrdered;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private AirPlane airPlane;
    public AirPlane getAirPlane(){
        return airPlane;
    }
}