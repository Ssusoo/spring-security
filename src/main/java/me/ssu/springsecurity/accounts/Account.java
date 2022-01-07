package me.ssu.springsecurity.accounts;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity @EqualsAndHashCode(of = "id")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Integer id;

    // TODO 유일한 값이기 때문에 unique=true
    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<AccountRole> roles;
}
