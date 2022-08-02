package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "FLIGHT_ROUTE_ID")
    private FlightRoute flightRoute;

    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "STATUS_ID")
    private Status status;

}
