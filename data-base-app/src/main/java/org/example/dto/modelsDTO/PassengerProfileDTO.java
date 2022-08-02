package org.example.dto.modelsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfileDTO {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
}

