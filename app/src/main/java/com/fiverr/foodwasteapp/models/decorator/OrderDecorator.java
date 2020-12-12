package com.fiverr.foodwasteapp.models.decorator;

import com.fiverr.foodwasteapp.models.Order;

/**
 * Create a Decorator
 * because an Order could to be denied or approved
 * more info: https://refactoring.guru/es/design-patterns/decorator
 */
public abstract class OrderDecorator implements IOrder {

    protected IOrder orderDecorator;

    public OrderDecorator(IOrder orderDecorator) {
        this.orderDecorator = orderDecorator;
    }

    @Override
    public void createOrder(Order order) {
        this.orderDecorator.createOrder(order);
    }
}
