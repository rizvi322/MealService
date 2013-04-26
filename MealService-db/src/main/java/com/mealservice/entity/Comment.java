package com.mealservice.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/22/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "comments")
@Access(AccessType.PROPERTY)
public class Comment implements Serializable {

    private int id;
    private String name;
    private String comment;
    private String time;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "comment_time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
