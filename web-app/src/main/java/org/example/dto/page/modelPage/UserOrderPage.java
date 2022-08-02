package org.example.dto.page.modelPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderPage {
    private Long id;
    private FlightRoutePage flightRoutePage;
    private StatusPage statusPage;
}
