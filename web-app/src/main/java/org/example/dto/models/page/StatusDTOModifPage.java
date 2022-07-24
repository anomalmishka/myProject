package org.example.dto.models.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatusDTOModifPage {
    private Long idStatus;
    private String statusStatus;

    private List<Long> idUserOrder;
}
