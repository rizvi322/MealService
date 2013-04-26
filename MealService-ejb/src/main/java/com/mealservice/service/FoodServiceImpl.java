package com.mealservice.service;

import com.mealservice.dao.FoodDao;
import com.mealservice.entity.Food;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/22/13
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class FoodServiceImpl implements FoodService {

    @EJB
    private FoodDao foodDao;
    private Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());

    @Override
    public void add(Food food) {

        logger.info(new Date() + " : Adding a new food named " + food.getName() + ".");
        foodDao.add(food);
        logger.info(new Date() + " : New Food Added.");
    }

    @Override
    public List<Food> showAll() {

        logger.info(new Date() + " : Returning the list of foods.");
        return foodDao.showAll();
    }

    @Override
    public void remove(int id) {

        logger.info(new Date() + " : Removing a food with id " + id + ".");
        foodDao.remove(id);
        logger.info(new Date() + " : Food Removed.");
    }

    public FoodDao getFoodDao() {
        return foodDao;
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }
}