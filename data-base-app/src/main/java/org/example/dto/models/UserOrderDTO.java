package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entity.Status;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOrderDTO {
    private Long id;
    private Status status;
}
