package org.example.model;

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
    @Column(name = "id")
    private Long id;
    private Integer passengerSeat;
    private Boolean isEmptySeat;
    private Boolean isActive;
    @ManyToOne
    private AirPlane airPlane;
    @ManyToOne
    private User user;
}
