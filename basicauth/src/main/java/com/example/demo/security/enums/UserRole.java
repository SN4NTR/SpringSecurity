package com.example.demo.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static com.example.demo.security.enums.UserAuthority.ADMIN_READ;
import static com.example.demo.security.enums.UserAuthority.ADMIN_WRITE;
import static com.example.demo.security.enums.UserAuthority.USER_READ;
import static com.example.demo.security.enums.UserAuthority.USER_WRITE;
import static java.util.stream.Collectors.toSet;

@AllArgsConstructor
public enum UserRole {

    ADMIN(Set.of(ADMIN_READ, ADMIN_WRITE)),
    USER(Set.of(USER_READ, USER_WRITE));

    @Getter
    private final Set<UserAuthority> authorities;

    public Set<? extends GrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getValue()))
                .collect(toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
