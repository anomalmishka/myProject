package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.UserOrderDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTOModif {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
    private List<UserOrderDTO> userOrderDTOList;
}

