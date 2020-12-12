package com.fiverr.foodwasteapp.models.decorator;

import com.fiverr.foodwasteapp.models.Order;

/**
 * @class MyOrder
 * My Order is an simply class
 * that only instance order to don't change the Order object
 */
public class MyOrder implements IOrder {
    // Create an Order object
    Order order;

    /**
     * Override Method implemented from Interface
     * @param order is the request that the user make to receiver a donation
     */
    @Override
    public void createOrder(Order order) {
        this.order = order;
    }

    /**
     * Getter Order object
     * @return Order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Setter Order Object
     * @param order is the request that the user make to receiver a donation
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
