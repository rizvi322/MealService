package com.mealservice.dao;

import com.mealservice.entity.AssignMeal;
import com.mealservice.entity.Meal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/1/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class MealDaoImpl implements MealDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public void add(Meal meal) {

        entityManager.persist(meal);
    }

    @Override
    public List<Meal> showAll() {

        TypedQuery<Meal> query = entityManager.createQuery("select m from Meal m", Meal.class);
        return query.getResultList();
    }

    @Override
    public void remove(int id) {

        Meal meal = entityManager.find(Meal.class, id);
        entityManager.remove(meal);
    }

    @Override
    public Meal getMealById(int id) {

        return entityManager.find(Meal.class, id);
    }

    @Override
    public void assignMeal(AssignMeal assignMeal) {

        entityManager.persist(assignMeal);
    }

    @Override
    public List<AssignMeal> showAssignedMeal() {

        String for_date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
        TypedQuery<AssignMeal> query = entityManager.createQuery("select a " +
                                                "from AssignMeal a " +
                                                "where a.for_date=:for_date",AssignMeal.class)
                                                .setParameter("for_date", for_date);
        return query.getResultList();
    }

    @Override
    public void removeAssign(int id) {

        AssignMeal assignMeal = entityManager.find(AssignMeal.class, id);
        entityManager.remove(assignMeal);
    }
}
