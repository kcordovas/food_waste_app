package com.fiverr.foodwasteapp.controller.interfaces;

import com.fiverr.foodwasteapp.models.User;

public interface IUserView {
    void onSuccessLogin(User user);
    void onFailLogin(String message);
}
