package com.fiverr.foodwasteapp.models;

/**
 * Person class is an object to instance of an common person
 * This class could to be modified conform to new requests
 * For example: surname, identification card, picture image, etc.
 */
public class Person {
    // Id variable is an unique identification
    // into of the app and the server
    // (this id'll to be to create automate when person create an user)
    // not is an identification card
    private String id;
    // Name is the real name of the person
    // if you want to see the user name to server (visit @User class)
    private String name;

    /**
     * Constructor
     * @param id is the unique identifier
     * @param name is the real name of person
     */
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter to id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter to real name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter the id
     * @param id is an unique identifier into the server
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter the real name
     * @param name is the real name
     */
    public void setName(String name) {
        this.name = name;
    }
}
