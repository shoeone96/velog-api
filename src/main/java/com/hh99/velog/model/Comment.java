package com.hh99.velog.model;

import com.hh99.velog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long articleId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto requestDto){
        this.articleId = requestDto.getArticleId();
        this.comment = requestDto.getComment();
        this.username = requestDto.getUsername();
    }

    public void update(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }

}
