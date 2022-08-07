package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTOModif {
    private Long id;
    private String passengername;
    private String passengerlastname;
    private String passportNumber;
    private List<UserOrderDTOModif> userOrderList;
}

