package com.bgnc.personalfinancemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity {
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;
}
