package org.example.model.obj.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompany {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private Integer priceLowcostIndex;
    private Integer priceBuisnessIndex;
}
