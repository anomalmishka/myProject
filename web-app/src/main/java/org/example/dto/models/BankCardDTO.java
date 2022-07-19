package org.example.dto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankCardDTO {
    private Long id;
    private CardType cardType;
    private Bank bank;
    private String holderName;
    private String holderLastname;
    private Long cardNumber;
    private Date serviceEndDate;
}
