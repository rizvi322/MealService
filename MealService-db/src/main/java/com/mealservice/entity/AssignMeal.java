package com.mealservice.entity;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/1/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "assign_meal")
@Access(AccessType.PROPERTY)
public class AssignMeal implements Serializable {

    private int id;
    private String meal_time;
    private String description;
    private String for_date;
    private int meal_id;
    private Meal meal;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeal_time() {
        return meal_time;
    }

    public void setMeal_time(String meal_time) {
        this.meal_time = meal_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFor_date() {
        return for_date;
    }

    public void setFor_date(String for_date) {
        this.for_date = for_date;
    }

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Transient
    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }
}
