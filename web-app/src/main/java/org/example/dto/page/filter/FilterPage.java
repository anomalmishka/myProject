package org.example.dto.page.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilterPage {
    private String routeStart;
    private String routeEnd;
    private String dateStart;
    private String dateEnd;
    private String priceEnd;
    private String airCompany;
    private String transfers;
    private String durationEnd;

    private String routeStartCheckbox;
    private String routeEndCheckbox;
    private String dateStartCheckbox;
    private String dateEndCheckbox;
    private String priceStartCheckbox;
    private String airCompanyCheckbox;
    private String transfersCheckbox;
    private String flightDurationCheckbox;
}
