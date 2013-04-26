package com.mealservice.controller;

import com.mealservice.entity.AssignMeal;
import com.mealservice.entity.Meal;
import com.mealservice.service.MealService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
public class MealController {

    List<AssignMeal> assignMealList;
    List<Meal> mealList;
    private Meal meal;
    private AssignMeal assignMeal;

    private String items[];

    @EJB
    private MealService mealService;

    @PostConstruct
    public void init() {
        if (assignMeal == null) {
            assignMeal = new AssignMeal();
        }

        if (meal == null) {
            meal = new Meal();
        }

        mealList = mealService.showAll();
        assignMealList = mealService.showAssignedMeal();
    }

    public String add() {
        if (meal != null) {
            meal.setItems(Arrays.toString(items));
            mealService.add(meal);
            mealList = mealService.showAll();
        }
        return "show_meal.xhtml?faces-redirect=true";
    }

    public String remove() {

        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(map.get("id"));
        mealService.remove(id);
        mealList = mealService.showAll();
        return "show_meal.xhtml?faces-redirect=true";
    }

    public String assign() {
        if (assignMeal != null) {
            String for_date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
            assignMeal.setMeal(mealService.getMealById(assignMeal.getMeal_id()));
            assignMeal.setFor_date(for_date);
            mealService.assignMeal(assignMeal);
            assignMealList = mealService.showAssignedMeal();
        }
        return "show_assign_meal.xhtml?faces-redirect=true";
    }

    public String removeAssign() {

        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(map.get("assign_id"));
        mealService.removeAssign(id);
        assignMealList = mealService.showAssignedMeal();
        return "show_assign_meal.xhtml?faces-redirect=true";
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getItems() {
        return items;
    }

    public List<Meal> getMealList() {

        return mealList;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public AssignMeal getAssignMeal() {
        return assignMeal;
    }

    public void setAssignMeal(AssignMeal assignMeal) {
        this.assignMeal = assignMeal;
    }

    public List<AssignMeal> getAssignMealList() {

        return assignMealList;
    }

}
