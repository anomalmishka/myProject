package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AUTHORITIES")
public class Authorities implements GrantedAuthority {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Transient
    @ManyToMany(mappedBy = "AUTHORITIES")
    private List<Login> logins;

    @Override
    public String getAuthority() {
        return getName();
    }
}
