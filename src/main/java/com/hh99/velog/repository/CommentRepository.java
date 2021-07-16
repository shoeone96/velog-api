package com.hh99.velog.repository;

import com.hh99.velog.dto.CommentRequestDto;
import com.hh99.velog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
}
