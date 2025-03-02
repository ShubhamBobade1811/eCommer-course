package com.social.media.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SocialProfile {

    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "SocialUser")
    private SocialUser user;
}
