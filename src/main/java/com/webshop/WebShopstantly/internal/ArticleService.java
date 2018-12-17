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
        System.out.println(this.printPackingSlip(articleToRecude, number));
    }

    public String printPackingSlip(Article article, int stock){
       String place = article.getPlace();
       String packingSlip = "----------------------------------------------\n Packing Slip für Artikel:\t| "+article.getName()+"\n Anzahl:\t\t\t\t\t| "+stock+"\n Ort:\t\t\t\t\t\t| "+place+"\n----------------------------------------------";
       return packingSlip;
    }
}
