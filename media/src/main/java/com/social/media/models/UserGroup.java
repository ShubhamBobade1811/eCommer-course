package com.social.media.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserGroup {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "userGroups")
    private Set<SocialUser> socialUsers = new HashSet<>();

}
