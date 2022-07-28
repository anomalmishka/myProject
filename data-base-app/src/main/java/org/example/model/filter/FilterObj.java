package org.example.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilterObj {
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
}
