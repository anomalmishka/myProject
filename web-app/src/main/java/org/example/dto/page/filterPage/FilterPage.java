package org.example.dto.page.filterPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


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
    private String airCompanyName;
    private String transfers;
    private String durationEnd;

    private String routeStartCheckbox;
    private String routeEndCheckbox;
    private String dateStartCheckbox;
    private String dateEndCheckbox;
    private String priceStartCheckbox;
    private String airCompanyNameCheckbox;
    private String transfersCheckbox;
    private String flightDurationCheckbox;
}
