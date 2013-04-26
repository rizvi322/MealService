package com.mealservice.service;

import com.mealservice.dao.CommentDao;
import com.mealservice.entity.Comment;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/25/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class CommentServiceImpl implements CommentService {

    @EJB
    private CommentDao commentDao;
    private Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());

    @Override
    public void addComment(Comment comment) {

        logger.info(new Date() + " : Adding a new Comment from " + comment.getName() +".");
        commentDao.addComment(comment);
        logger.info(new Date() + " : New Comment Added.");
    }

    @Override
    public List<Comment> showComments() {

        logger.info(new Date() + " : Returning the list of comments.");
        return commentDao.showComments();
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
}
