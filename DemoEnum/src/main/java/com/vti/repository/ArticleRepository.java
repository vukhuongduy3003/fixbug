package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class ArticleRepository {

	private HibernateUtils hibernateUtils;

	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Article> query = session.createQuery("FROM Article");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createArticle(Article article) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(article);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
