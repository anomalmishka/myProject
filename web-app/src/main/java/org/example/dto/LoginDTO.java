package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginDTO {
    private String username;
    private String password;
    private String passwordConfirm;
    private String authorities;
    private String isEnabled;
}
