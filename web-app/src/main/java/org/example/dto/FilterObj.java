package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilterObj {
    private String routeStart;
    private String routeEnd;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Integer priceStart;
    private Integer priceEnd;
    private String airCompanyName;
    private String transfers;
    private Integer durationStart;
    private Integer durationEnd;

    private Boolean routeStartCheckbox;
    private Boolean routeEndCheckbox;
    private Boolean dateStartCheckbox;
    private Boolean dateEndCheckbox;
    private Boolean priceStartCheckbox;
    private Boolean airCompanyNameCheckbox;
    private Boolean transfersCheckbox;
    private Boolean flightDurationCheckbox;
}
