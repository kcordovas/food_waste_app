package com.fiverr.foodwasteapp.models.decorator;

import com.fiverr.foodwasteapp.models.Order;
import com.fiverr.foodwasteapp.utils.Utils;

/**
 * OrderApproved is the class that contain all attribute
 * how isDelivered or verificationCode
 */
public class OrderApproved extends OrderDecorator {
    // Variable isDelivered is to verify if request is delivered
    boolean isDelivered;
    // Verification Code is to concatenate with user
    String verificationCode;
    // Direction object is to send to map the latitude and longitude
    // Change this object conform your form that send data to map
    // more info review here Direction object
    Direction direction;

    /**
     * Constructor to instance the IOrder instance of Order
     * @param orderDecorator is the order that send
     */
    public OrderApproved(IOrder orderDecorator) {
        super(orderDecorator);
    }

    /**
     * Method to init variables, exclusive only to approved
     * @param order is the normal order without changes
     */
    @Override
    public void createOrder(Order order) {
        orderDecorator.createOrder(order);
        // Changes state of Order for approved
        order.setApproved(true);
        // First init the isDelivered in false
        // because this change when the user receiver your donation
        this.isDelivered = false;
        // Create an verification code Random
        // Here Is generated of Form Offline with a Random method
        // Change conform your requests
        this.verificationCode = Utils.generateRandomCodeVerification();
    }

    /**
     * Getter isDelivered
     * @return isDelivered
     */
    public boolean isDelivered() {
        return isDelivered;
    }

    /**
     * Setter if this delivered
     * @param delivered is to verify if request is delivered
     */
    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    /**
     * Getter Verification code
     * @return string verification code
     */
    public String getVerificationCode() {
        return verificationCode;
    }

    /**
     * Setter Verification Code, if you could make an by online generator
     * @param verificationCode is to concatenate with user
     */
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    /**
     * Getter Direction object
     * @return Direction object
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Setter Direction is an object to send to map
     * @param direction is the object
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Direction Object is to instance an form to send data for map
     * Could to be only a string, latitude, longitude, maps markets google, etc.
     */
    public static class Direction {
        // Longitude to send to map
        double longitudeMap;
        // Latitude to sent to map
        double latitudeMap;

        /**
         * Constructor to init the values based on latitude and longitude
         * @param longitudeMap is the longitude to send for the map
         * @param latitudeMap is the latitude to send for the map
         */
        public Direction(double longitudeMap, double latitudeMap) {
            this.longitudeMap = longitudeMap;
            this.latitudeMap = latitudeMap;
        }

        /**
         * Getter the longitude
         * @return double longitude
         */
        public double getLongitudeMap() {
            return longitudeMap;
        }

        /**
         * Setter Longitude conform the request map
         * @param longitudeMap is the longitude to send for the map
         */
        public void setLongitudeMap(double longitudeMap) {
            this.longitudeMap = longitudeMap;
        }

        /**
         * Getter the latitude
         * @return double latitude
         */
        public double getLatitudeMap() {
            return latitudeMap;
        }

        /**
         * Setter latitude conform the request map
         * @param latitudeMap is the latitude to send for the map
         */
        public void setLatitudeMap(double latitudeMap) {
            this.latitudeMap = latitudeMap;
        }
    }
}
