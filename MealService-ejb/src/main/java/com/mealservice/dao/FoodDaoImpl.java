package com.mealservice.dao;

import com.mealservice.entity.Food;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/24/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class FoodDaoImpl implements FoodDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public void add(Food food) {

        entityManager.persist(food);
    }

    @Override
    public List<Food> showAll() {

        TypedQuery<Food> query = entityManager.createQuery("select f from Food f", Food.class);
        return query.getResultList();
    }

    @Override
    public void remove(int id) {

        Food food = entityManager.find(Food.class, id);
        entityManager.remove(food);
    }
}
