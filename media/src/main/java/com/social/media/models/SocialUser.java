package com.social.media.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser")
    @JoinColumn(name = "SocialProfile")
    private SocialProfile socialProfile;

    @ManyToMany
    private Set<UserGroup> userGroups = new HashSet<>();

}
