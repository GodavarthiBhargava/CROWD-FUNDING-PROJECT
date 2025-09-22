package com.cicd.sdp.cfp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contributors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean blocked = false;
}

