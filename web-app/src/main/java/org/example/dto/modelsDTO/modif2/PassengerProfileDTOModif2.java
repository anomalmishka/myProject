package org.example.dto.modelsDTO.modif2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTOModif2 {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
    private List<UserOrderDTOModif2> userOrderDTOModif2List;
}

