package com.example.jpademo;

import com.example.jpademo.entity.ArticleEntity;
import com.example.jpademo.repo.ArticleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final ArticleRepository repository;

    @GetMapping("/test/{id}")
    public String test(
            @PathVariable
            Long id
    ) {
        // CREATE
        // 1. 새로운 ArticleEntity 인스턴스를 만든다.
        ArticleEntity article = new ArticleEntity();
        // 2. 인스턴스에 내가 저장하고 싶은 데이터를 넣어준다.
        article.setTitle("Test");
        article.setContent("Lorem Ipsum");
        article.setWriter("Alex");
        // 3. repository 의 save 메서드를 이용해서 저장한다.
        repository.save(article);

        //READ ALL
        List<ArticleEntity> articles = repository.findAll();
        for (ArticleEntity entity : articles) {
            System.out.println(entity.toString());
        }

        // READ ONE
        Optional<ArticleEntity> optionalArticle = repository.findById(4L);
        if (optionalArticle.isPresent()) {
            System.out.println("found: 4L");
            System.out.println(optionalArticle.get());
        }

        // UPDATE
        // 어떤 ArticleEntity 있고 title 을 바꾼다
        Optional<ArticleEntity> targetOptional = repository.findById(id);
        if (targetOptional.isPresent()) {
            System.out.println("target found");
            ArticleEntity target = targetOptional.get();
            // title 을 "updated title" 이라는 문자열로 바꾸고 싶다
            target.setTitle("updated title");
            repository.save(target);
        }

        // DELETE
//        targetOptional = repository.findById(id); // 누굴 삭제할 건지 id를 받아 와야 하므로
//        if (targetOptional.isPresent()) {
//            System.out.println("delete target found");
//            ArticleEntity target = targetOptional.get();
//            repository.delete(target);
//        }
        repository.deleteById(id);

        return "done";
    }
}


