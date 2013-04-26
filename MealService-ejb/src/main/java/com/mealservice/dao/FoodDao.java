package com.mealservice.dao;

import com.mealservice.entity.Food;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/24/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */

public interface FoodDao {

    public void add(Food food);
    public List<Food> showAll();
    public void remove(int id);

}
