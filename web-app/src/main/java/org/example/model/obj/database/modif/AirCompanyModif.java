package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.AirPlane;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyModif {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private Integer priceLowcostIndex;
    private Integer priceBuisnessIndex;
    private List<AirPlane> airPlaneList;
}
