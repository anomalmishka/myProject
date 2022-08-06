package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "USER_LOGIN")
public class UserLogin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "USERPASSWORD")
    private String password;
    @Transient
    @Column(name = "PASSWORD_CONFIRM")
    private String passwordConfirm;
    @Column(name = "ACCOUNT_NON_EXPIRED")
    private Boolean isAccountNonExpired;
    @Column(name = "ACCOUNT_NON_LOCKED")
    private Boolean isAccountNonLocked;
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private Boolean isCredentialsNonExpired;
    @Column(name = "ENABLED")
    private Boolean isEnabled;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authorities> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}