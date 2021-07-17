package com.hh99.velog.repository;

import com.hh99.velog.dto.CommentRequestDto;
import com.hh99.velog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleIdOrderByCreatedAtDesc(Long articleId);
    List<Comment> findAllByOrderByModifiedAtDesc();
}
