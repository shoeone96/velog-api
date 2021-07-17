package com.hh99.velog.controller;

import com.hh99.velog.dto.CommentRequestDto;
import com.hh99.velog.model.Comment;
import com.hh99.velog.repository.CommentRepository;
import com.hh99.velog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/comment")     // 모든 댓글 다 불러오기
    public List<Comment> getAllComment() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/comment/{articleId}")     // 게시글 별 댓글 불러오기
    public List<Comment> readComments(@PathVariable Long articleId) {
        return commentRepository.findAllByArticleIdOrderByCreatedAtDesc(articleId);
    }

    @PostMapping("/comment")        // 댓글 포스팅
    public Comment postComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/comment/{id}")        // 댓글 수정
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/comment/{id}")     // 댓글 삭제
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
