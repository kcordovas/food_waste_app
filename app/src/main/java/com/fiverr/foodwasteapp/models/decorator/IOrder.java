package com.fiverr.foodwasteapp.models.decorator;

import com.fiverr.foodwasteapp.models.Order;

/**
 * IOrder Interface is to create an Instance of Order Object
 */
public interface IOrder {
    /**
     * create Order is use to init the Order object
     * @param order is the request that the user make to receiver a donation
     */
    void createOrder(Order order);
}
