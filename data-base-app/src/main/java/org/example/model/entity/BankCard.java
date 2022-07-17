package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "BANK_CARD")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private CardType cardType;
    private Bank bank;
    private String holderName;
    private String holderLastname;
    private Long cardNumber;
    private Date serviceEndDate;

    @ManyToOne
    private User user;
}
