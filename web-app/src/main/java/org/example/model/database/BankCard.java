package org.example.model.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankCard {
    private Long id;
    private Long cardNumber;
    private UserProfile userProfile;
}
