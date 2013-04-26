package com.mealservice.controller;

import com.mealservice.backing.User;
import org.apache.log4j.Logger;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/22/13
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private User user;

    private Logger logger = Logger.getLogger(LoginController.class.getName());

    public String login()
    {
        if(user != null)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            if(user.getUsername().equals("admin") && user.getPassword().equals("admin"))
            {
                HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                logger.info(new Date() + " : " + user.getUsername() + " logged in.");
                return "show_assign_meal.xhtml?faces-redirect=true";
            }
            else
            {
                logger.debug(new Date() + " : Invalid username : " + user.getUsername() + " or password : " + user.getPassword());
                context.addMessage(null, new FacesMessage("Wrong Username or Password or Both"));
            }
        }

        return null;
    }

    @PreDestroy
    public String logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        HttpSession session = request.getSession(true);
        session.invalidate();
        logger.info(new Date() + " : " + user.getUsername() + " logged out.");
        user = null;

        return "index.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
