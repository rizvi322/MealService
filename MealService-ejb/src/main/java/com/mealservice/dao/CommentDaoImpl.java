package com.mealservice.dao;

import com.mealservice.entity.Comment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/24/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CommentDaoImpl implements CommentDao{

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public void addComment(Comment comment) {

        entityManager.persist(comment);
    }

    @Override
    public List<Comment> showComments() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c order by id desc", Comment.class);
        query.setMaxResults(5);
        return query.getResultList();
    }
}
