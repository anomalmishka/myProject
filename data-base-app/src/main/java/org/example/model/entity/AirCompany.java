package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AIR_COMPANY")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME_COMPANY")
    private String nameCompany;
    @Column(name = "COUNTRY_LOCATION")
    private String countryLocation;
    @Column(name = "PRICE_LOWCOST_INDEX")
    private Integer priceLowcostIndex;
    @Column(name = "PRICE_BUISNESS_INDEX")
    private Integer priceBuisnessIndex;

    @OneToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "AIR_COMPANY_ID")
    private List<AirPlane> airPlaneList;
}
