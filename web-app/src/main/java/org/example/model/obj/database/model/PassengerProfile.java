package org.example.model.obj.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfile {
    private Long id;
    private String name;
    private String lastname;
    private String passportNumber;
}

