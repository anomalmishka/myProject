package org.example.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Column(name = "PROFILENAME")
    private String profilename;
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy="userProfile"
    )
    private List<BankCard> bankCardList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy="userProfile"
    )
    private List<PassengerProfile> passengerProfileList;
}

