package com.hh99.velog.model;


import com.hh99.velog.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

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


    public Article(Long id, String title, String contents,String description,int commentCount,
                   String username , int likeCount, String profileImage, String thumbnail) {
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.description=description;
        this.commentCount=commentCount;
        this.username = username;
        this.likeCount=likeCount;
        this.profileImage=profileImage;
        this.thumbnail=thumbnail;


    }

    public Article(ArticleRequestDto requestDto) {
        this.id=requestDto.getId();
        this.title=requestDto.getTitle();
        this.contents=requestDto.getContents();
        this.description=requestDto.getUsername();
        this.commentCount=requestDto.getCommentCount();
        this.username=requestDto.getUsername();
        this.likeCount=requestDto.getLikeCount();
        this.profileImage=requestDto.getProfileImage();
        this.thumbnail=requestDto.getThumbnail();
    }

    public void update(ArticleRequestDto requestDto) {
        this.id = requestDto.getId();
    }


    }
