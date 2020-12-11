package com.fiverr.foodwasteapp.models;

/**
 * User class is the object that contain
 * the data about the user name and password
 * this user contain some more params
 * how state (Connected, Inactive).
 * Modify conform user object to request
 */
public class User {
    // IdUser is an unique identification
    // into server, it's necessary to instance with
    // other objects, how Business class or Person class
    private String idUser;
    // User name is the name that identify the user into the app
    private String user;
    // Password with format string could to be with 6 and more length
    private String pwd;
    // State is to identify that the user is Connected or Inactive
    // 1 - Connected
    // 0 - Inactive
    // Could to be more states conform to requests
    private int state = 1;

    /**
     * Constructor
     * @param idUser is an unique identification
     * @param user is the name that identify the user into the app
     * @param pwd is the password that user input
     */
    public User(String idUser, String user, String pwd) {
        this.idUser = idUser;
        this.user = user;
        this.pwd = pwd;
    }

    /**
     * Getter the id of user
     * @return idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * Setter the user identification
     * @param idUser is an unique identification
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * Getter name user
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter the user name
     * @param user is the name that identify the user into the app
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter password
     * @return pwd (password)
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Setter the password
     * @param pwd is the password that user input
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Getter State of connectivity
     * 1 - Connected
     * 0 - Inactive
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * Setter state of connectivity
     * @param state is to identify that the user is Connected or Inactive
     */
    public void setState(int state) {
        this.state = state;
    }
}
