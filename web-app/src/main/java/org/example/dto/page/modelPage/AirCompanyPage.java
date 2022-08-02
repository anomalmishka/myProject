package org.example.dto.page.modelPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AirCompanyPage {
    private Long id;
    private String nameCompany;
    private String countryLocation;
}
