package com.hh99.velog.model;

import javax.persistence.*;

public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int commentCount;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private int likeCount;

    @Column(nullable = false)
    private String profileImage;

    @Column(nullable = false)
    private String thumbnail;




}
