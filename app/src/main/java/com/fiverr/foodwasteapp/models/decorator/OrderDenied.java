package com.fiverr.foodwasteapp.models.decorator;

import com.fiverr.foodwasteapp.models.Order;

/**
 * @class OrderDenied
 * This class is instance when foundation denied an user request
 * Here only the foundation add an message.
 * Change this class conform your requests
 */
public class OrderDenied extends OrderDecorator {
    // Note when foundation denied user request
    // Only an string simple
    String noteDenied;

    /**
     * Constructor to get the Order init
     * @param orderDecorator is the decorator instance to add this functionality
     */
    public OrderDenied(IOrder orderDecorator) {
        super(orderDecorator);
    }

    /**
     * Method to init variables, exclusive only to denied
     * Here order state is change to negate, that is to say,
     * variable isApproved to false
     * @param order is the normal order without changes
     */
    @Override
    public void createOrder(Order order) {
        super.createOrder(order);
        order.setApproved(false);
    }

    /**
     * Getter Note Denied
     * @return string note
     */
    public String getNoteDenied() {
        return noteDenied;
    }

    /**
     * Setter the noteDenied with the message
     * @param noteDenied is the message that foundation generate to explain about the denied request
     */
    public void setNoteDenied(String noteDenied) {
        this.noteDenied = noteDenied;
    }
}
