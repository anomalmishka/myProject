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
public class FilterObj {
    private String routeStart;
    private String routeEnd;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Integer price;
    private String airCompanyName;
    private String transfer;
    private Integer duration;
}
