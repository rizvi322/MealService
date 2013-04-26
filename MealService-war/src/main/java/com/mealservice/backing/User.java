package com.mealservice.backing;

import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 4/22/13
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class User implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
