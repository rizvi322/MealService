package com.mealservice.controller;

import com.mealservice.entity.Food;
import com.mealservice.service.FoodService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/18/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class FoodController {

    List<Food> foodList;
    private Food food;

    @EJB
    private FoodService foodService;

    @PostConstruct
    public void init() {
        if (food == null) {
            food = new Food();
        }
        foodList = foodService.showAll();
    }

    public String add() {
        if (food != null) {
            foodService.add(food);
            foodList = foodService.showAll();
        }
        return "show_food.xhtml?faces-redirect=true";
    }

    public String remove() {

        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(map.get("id"));
        foodService.remove(id);
        foodList = foodService.showAll();
        return "show_food.xhtml?faces-redirect=true";
    }


    public List<Food> getFoodList() {

        //foodList = foodService.showAll();
        return foodList;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

}
