package org.example.dto.modelsDTO.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.modelsDTO.BankCardDTO;
import org.example.dto.modelsDTO.TicketDTO;
import org.example.model.entity.BankCard;
import org.example.model.entity.Ticket;

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
