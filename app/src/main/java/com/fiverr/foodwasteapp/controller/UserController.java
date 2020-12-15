package com.fiverr.foodwasteapp.controller;

import com.fiverr.foodwasteapp.controller.interfaces.IUserController;
import com.fiverr.foodwasteapp.controller.interfaces.IUserView;
import com.fiverr.foodwasteapp.models.User;
import com.fiverr.foodwasteapp.provider.UserModel;
import com.fiverr.foodwasteapp.provider.interfaces.IUserModel;

/**
 * MVC Design Pattern
 * This is user controller
 */
public class UserController implements IUserController {

    // Instance the view with the controller to communication
    private final IUserView userView;
    // Instance the user model to get data
    private final IUserModel userModel;

    public UserController(IUserView userView) {
        this.userView = userView;
        this.userModel = new UserModel();
    }

    /**
     * Verify if exists an user
     * if an user is in the database
     * verity the password
     * else send callback methods to view (Activity)
     * @param user is the input that send the Activity
     * @param pwd is the input that sent the Activity
     */
    @Override
    public void onLogin(String user, String pwd) {
        User myUser = null;
        for (int i = 0; i < userModel.getAllUser().size(); i++) {
            if (userModel.getAllUser().get(i).getUser().equalsIgnoreCase(user))
                myUser = userModel.getUserByIndex(i);
        }
        if (myUser == null) {
            userView.onFailLogin("User not Found");
            return;
        }

        if (myUser.getPwd().equals(pwd))
            userView.onSuccessLogin(myUser);
        else
            userView.onFailLogin("User/Password Incorrect");
    }
}
