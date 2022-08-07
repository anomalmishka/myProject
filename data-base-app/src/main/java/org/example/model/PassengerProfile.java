package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PASSENGER_PROFILE")
public class PassengerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PASSENGERNAME")
    private String passengername;
    @Column(name = "PASSENGERLASTNAME")
    private String passengerlastname;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "PASSENGER_PROFILE_ID")
    private List<UserOrder> userOrderList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private UserProfile userProfile;
    public UserProfile getUserProfile(){
        return userProfile;
    }
}
