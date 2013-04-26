package com.mealservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/22/13
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "foodlist")
@Access(AccessType.PROPERTY)
public class Food implements Serializable {

    private int id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
