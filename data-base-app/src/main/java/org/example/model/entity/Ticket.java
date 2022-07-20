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
@Entity(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToOne
    private Seat seat;

    @ManyToOne
    private UserOrder userOrder;

    @OneToOne
    private PassengerProfile passengerProfile;
}
