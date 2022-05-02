package com.vti.repository;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleRepository {
    private HibernateUtils hibernateUtils;

    public ArticleRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Article> getAllArticles() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("FROM Article ");
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
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
