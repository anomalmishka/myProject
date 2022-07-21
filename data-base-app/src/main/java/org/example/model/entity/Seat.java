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
@Entity(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ROW_SEAT")
    private Integer rowSeat;
    @Column(name = "PLACE")
    private Integer place;
    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    private AirPlane airPlane;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="TICKET_ID")
    private Ticket ticket;
}
