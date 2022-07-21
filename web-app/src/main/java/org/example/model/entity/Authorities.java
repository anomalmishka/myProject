package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AUTORITIES")
public class Authorities implements GrantedAuthority {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Transient
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="USER_ID")
    private User user;

    @Override
    public String getAuthority() {
        return getName();
    }
}
