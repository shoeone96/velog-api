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

    @GetMapping("/comment")
    public List<Comment> readComments() {
        return commentRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping("/comment")
    public Comment postComment(@RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
