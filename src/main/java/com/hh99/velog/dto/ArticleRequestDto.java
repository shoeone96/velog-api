package com.hh99.velog.dto;


import lombok.Getter;

@Getter
public class ArticleRequestDto {

    private Long id;
    private String title;
    private String description;
    private String contents;
    private int commentCount=0;
    private String username="user";
    private int likeCount=0;
    private String profileImage="default";
    private String thumbnail;
}
