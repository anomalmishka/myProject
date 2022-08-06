package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_COMPANY")
public class AirCompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME_COMPANY")
    private String nameCompany;
    @Column(name = "COUNTRY_LOCATION")
    private String countryLocation;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "AIR_COMPANY_ID")
    private List<AirPlane> airPlaneList;
}