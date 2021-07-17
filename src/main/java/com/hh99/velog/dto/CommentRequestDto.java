package com.hh99.velog.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long articleId;
    private String username;
    private String comment;
}
