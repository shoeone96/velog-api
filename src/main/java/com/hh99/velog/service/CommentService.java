package com.hh99.velog.service;

import com.hh99.velog.dto.CommentRequestDto;
import com.hh99.velog.model.Comment;
import com.hh99.velog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto commentRequestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("id가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        return id;
    }

    public List<Comment> readComments(Long articleId){
        return commentRepository.findAllByArticleIdOrderByCreatedAtDesc(articleId);
    }
}
