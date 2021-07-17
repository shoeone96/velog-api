package com.hh99.velog.controller;


import com.hh99.velog.dto.ArticleRequestDto;
import com.hh99.velog.model.Article;
import com.hh99.velog.repository.ArticleRepository;
import com.hh99.velog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;




    @PostMapping("/api/articles")
    public Article createArticle(@RequestBody ArticleRequestDto requestDto) {
        Article article = new Article(requestDto);
        return articleRepository.save(article);

    }


    @GetMapping("/api/articles")
    public List<Article> readArticle() {
        return articleRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/articles/{id}")
    public Long deleteArticle (@PathVariable Long id) {
        articleRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/articles/{id}")
    public Long updateArticle(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        articleService.update(id, requestDto);
        return id;
    }
}
