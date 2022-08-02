package org.example.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

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
}
