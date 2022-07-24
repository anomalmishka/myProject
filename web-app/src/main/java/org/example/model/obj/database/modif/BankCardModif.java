package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.UserProfile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankCardModif {
    private Long id;
    private Long cardNumber;
    private UserProfile userProfile;
}
