package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "USER_PROFILE")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private Integer phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IS_BLOCKET_PROFILE")
    private Boolean isBlockedProfile;

    @Column(name = "USER_ID")
    private Long userId;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="USER_PROFILE_ID")
    private List<UserOrder> userOrderList;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="USER_PROFILE_ID")
    private List<BankCard> bankCardList;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="USER_PROFILE_ID")
    private List<PassengerProfile> passengerProfileList;
}

