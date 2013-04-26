package com.mealservice.controller;

import com.mealservice.entity.Comment;
import com.mealservice.service.CommentService;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/22/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class CommentController {

    private Logger logger = Logger.getLogger(CommentController.class.getName());

    private Comment comment;
    private List<Comment> commentList;
    @EJB
    private CommentService commentService;

    @PostConstruct
    public void init() {
        if (comment == null) {
            comment = new Comment();
        }
        commentList = commentService.showComments();
    }

    public String add() {
        if (comment != null) {
            String time = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date());
            comment.setTime(time);
            commentService.addComment(comment);
            commentList = commentService.showComments();
        }
        return "index.xhtml?faces-redirect=true";
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

}
