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
    private String durationEnd;
}
