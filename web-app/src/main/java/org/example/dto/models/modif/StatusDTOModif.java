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
public class StatusDTOModif {
    private Long id;
    private String status;
    private List<UserOrderDTO> userOrderDTOList;
}
