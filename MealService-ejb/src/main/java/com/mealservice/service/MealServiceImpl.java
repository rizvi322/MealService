package com.mealservice.service;

import com.mealservice.dao.MealDao;
import com.mealservice.entity.AssignMeal;
import com.mealservice.entity.Meal;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/1/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class MealServiceImpl implements MealService {

    private Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());
    @EJB
    private MealDao mealDao;

    @Override
    public void add(Meal meal) {

        logger.info(new Date() + " : Adding a new meal package with items :  " + meal.getItems() +".");
        mealDao.add(meal);
        logger.info(new Date() + " : New Meal package Added.");
    }

    @Override
    public List<Meal> showAll() {

        logger.info(new Date() + " : Returning the list of meal packages.");
        return mealDao.showAll();
    }

    @Override
    public void remove(int id) {

        logger.info(new Date() + " : Removing a meal package with id " + id + ".");
        mealDao.remove(id);
        logger.info(new Date() + " : Meal Removed.");
    }

    @Override
    public Meal getMealById(int id) {

        return mealDao.getMealById(id);
    }

    @Override
    public void assignMeal(AssignMeal assignMeal) {

        logger.info(new Date() + " : Assigning a new meal package with items :  " + assignMeal.getMeal().getItems() +" for "+ assignMeal.getMeal_time() +".");
        mealDao.assignMeal(assignMeal);
        logger.info(new Date() + " : Meal package Assigned.");
    }

    @Override
    public List<AssignMeal> showAssignedMeal() {

        logger.info(new Date() + " : Returning the list of assigned meal packages.");
        return mealDao.showAssignedMeal();
    }

    @Override
    public void removeAssign(int id) {

        logger.info(new Date() + " : Removing assigned meal package with id " + id + ".");
        mealDao.removeAssign(id);
        logger.info(new Date() + " : Assigned Meal package Removed.");
    }

    public MealDao getMealDao() {
        return mealDao;
    }

    public void setMealDao(MealDao mealDao) {
        this.mealDao = mealDao;
    }
}
