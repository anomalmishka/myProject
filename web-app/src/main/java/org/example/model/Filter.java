package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Filter {
    private String routeStart;
    private String routeEnd;
    private Date dateStart;
    private Date dateEnd;
    private Integer priceStart;
    private Integer priceEnd;
    private String airCompany;
    private String transfers;
    private Integer durationStart;
    private Integer durationEnd;

    private Boolean routeStartCheckbox;
    private Boolean routeEndCheckbox;
    private Boolean dateStartCheckbox;
    private Boolean dateEndCheckbox;
    private Boolean priceStartCheckbox;
    private Boolean airCompanyCheckbox;
    private Boolean transfersCheckbox;
    private Boolean flightDurationCheckbox;
}
