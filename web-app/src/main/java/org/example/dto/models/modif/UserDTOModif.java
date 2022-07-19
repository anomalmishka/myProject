package org.example.dto.models.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.models.BankCardDTO;
import org.example.dto.models.TicketDTO;

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
    private List<BankCardDTO> bankCardDTOS;
    private List<TicketDTO> ticketDTOS;
}
