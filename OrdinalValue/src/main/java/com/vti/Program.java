package com.vti;

import com.vti.entity.Article;
import com.vti.entity.Status;
import com.vti.repository.ArticleRepository;

public class Program {
    public static void main(String[] args) {
        ArticleRepository repository = new ArticleRepository();

        System.out.println("***********GET ALL ARTICLES***********");
        for (Article article : repository.getAllArticles()) {
            System.out.println(article);
        }

        System.out.println("\n\n***********CREATE ARTICLE***********");
        Article article = Article.builder().title("Vũ Khương Duy").status(Status.OPEN).build();
        repository.createArticle(article);
    }
}
