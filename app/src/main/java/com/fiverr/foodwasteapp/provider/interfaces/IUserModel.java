package com.fiverr.foodwasteapp.provider.interfaces;

import com.fiverr.foodwasteapp.models.User;

import java.util.ArrayList;

public interface IUserModel {
    ArrayList<User> getAllUser();
    User getUserByIndex(int index);
    void removeUser(User user);
    void addUser(User user);
}
