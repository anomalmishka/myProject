package org.example.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "USER_ORDER")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private FlightRoute flightRoute;
    public FlightRoute getFlightRoute(){
        return flightRoute;
    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Status status;
    public Status getStatus(){
        return status;
    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private PassengerProfile passengerProfile;
    public PassengerProfile getPassengerProfile(){
        return passengerProfile;
    }
}
