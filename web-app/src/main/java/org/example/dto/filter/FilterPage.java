package org.example.dto.filter;

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
    private String price;
    private String airCompanyName;
    private String transfer;
    private String duration;

    private String routeStartCheckbox;
    private String routeEndCheckbox;
    private String dateStartCheckbox;
    private String dateEndCheckbox;
    private String priceCheckbox;
    private String airCompanyNameCheckbox;
    private String transferCheckbox;
    private String durationCheckbox;
}
