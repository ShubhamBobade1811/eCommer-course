package com.social.media.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    private Long id;

    @ManyToOne
    private SocialUser socialUser;

}
