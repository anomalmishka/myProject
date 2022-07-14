package org.example.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.BankCard;
import org.example.model.Ticket;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTOModif {
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
    private List<BankCard> bankCards;
    private List<Ticket> tickets;
}
