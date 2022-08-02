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
public class FilterDTO {
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
