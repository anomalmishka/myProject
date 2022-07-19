package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private Character sex;
    private Integer phone;
    private String passportNumber;
    private String email;
    private Long age;
    private String categoryClient;
    private Boolean isActiveProfile;
}
