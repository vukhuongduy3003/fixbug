package com.vti;

import java.util.List;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

public class Program {
	public static void main(String[] args) {
		ArticleRepository repository = new ArticleRepository();

		System.out.println("***********GET ALL ARTICLES***********");

		List<Article> articles = repository.getAllArticles();

		for (Article article : articles) {
			System.out.println(article);
		}

		System.out.println("\n\n***********CREATE ARTICLE***********");

		Article article = Article.builder().title("6").status(Article.Status.OPEN).build();
		repository.createArticle(article);

	}
}
