package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyDTO {
    private Long id;
    private String nameCompany;
    private String countryLocation;
    private Integer priceLowcostIndex;
    private Integer priceBuisnessIndex;
}
