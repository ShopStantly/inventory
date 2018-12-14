package com.webshop.WebShopstantly.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void reduceStockOfArticle(Article article, int number) {
        List<Article> articles = articleRepository.findAll();
        Optional<Article> wantedArticle = articles.stream().filter(a -> article.getName().equals(a.getName())).findFirst();
        Article articleToRecude = wantedArticle.orElseThrow(NullPointerException::new);
        articleToRecude.setStock(articleToRecude.getStock() - number);
        articleRepository.save(articleToRecude);
    }

}
