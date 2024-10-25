package com.bgnc.personalfinancemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Builder
public class User extends BaseEntity implements Serializable, UserDetails {

    @Column(name = "username", nullable = false,unique = true)
    @NotEmpty(message = "The username field is required")
    private String username;

    @Column(name = "passowrd",nullable = false)
    @NotEmpty(message = "The password field is required")
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
