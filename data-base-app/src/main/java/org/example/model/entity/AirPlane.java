package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_PLANE")
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String type;
    private String routeStart;
    private String routeEnd;
    private Integer ticketPrice;
    private Integer numberPassanger;
    private Date flightDateStart;
    private Date flightDateEnd;

    @ManyToOne
    private AirCompany airCompany;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="AIR_PLANE_ID")
    private List<Ticket> tickets;
}
