package com.fiverr.foodwasteapp.provider;

import com.fiverr.foodwasteapp.models.User;
import com.fiverr.foodwasteapp.provider.interfaces.IUserModel;

import java.util.ArrayList;

/**
 * MVC Patter This is the model
 * to get Data of a provider
 */
public class UserModel implements IUserModel {
    ArrayList<User> userArrayList = new ArrayList<>();

    public UserModel() {
        addUser(new User("123", "user1", "123456"));
    }

    @Override
    public ArrayList<User> getAllUser() {
        return userArrayList;
    }

    @Override
    public User getUserByIndex(int index) {
        return userArrayList.get(index);
    }

    @Override
    public void removeUser(User user) {
        userArrayList.remove(user);
    }

    @Override
    public void addUser(User user) {
        userArrayList.add(user);
    }
}
