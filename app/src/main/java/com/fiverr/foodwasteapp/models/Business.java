package com.fiverr.foodwasteapp.models;

/**
 * Business class is the object that could to use
 * how for foods company, clothes company or furniture companies.
 * or for charity organizations, foundations, homeless shelters, etc too.
 */
public class Business {
    // Id is an identifier unique into the server
    // (it'll to be to create with automate form when business create an user)
    private String id;
    // Name is the real name of company or organization
    private String name;
    // UrlPicture is the url image
    // url image will save in server to when user download the app
    // the image of organizations will get of server
    private String urlPicture;
    // User object have user name and password with his own id
    // more details about this object visit the User class
    private User user;

    // Type is to identify if it's a charity organizations, foundations, etc.
    // or to a food company, clothes company, etc.
    // WHERE
    // 1 - Charity Organizations
    // 2 - Foundations
    // 3 - Homeless shelters
    // 0 - others that if aren't nonprofit
    private int type;

    /**
     * Constructor
     * @param id is unique identifier generated of automate form
     * @param name is the real name of company or organization
     * @param user is the object that contain user name and password
     * @param type is the business type (charity organizations, foundations or others)
     */
    public Business(String id, String name, String urlPicture, int type, User user) {
        this.id = id;
        this.name = name;
        this.urlPicture = urlPicture;
        this.user = user;
        this.type = type;
    }

    /**
     * Second Constructor
     * @param id is unique identifier generated of automate form
     * @param name is the real name of company or organization
     * @param urlPicture is the url picture
     * @param type is the business type (charity organizations, foundations or others)
     */
    public Business(String id, String name, String urlPicture, int type) {
        this.id = id;
        this.name = name;
        this.urlPicture = urlPicture;
        this.type = type;
    }

    /**
     * Getter type
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Setter the type to identify the type of organizations
     * @param type is the business type (charity organizations, foundations or others)
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Getter User object
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter User object
     * @param user object will receiver
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter ID object
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter id generate of automate form
     * @param id is an unique identification into server
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter the real name of company
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter the real name of company
     * @param name is the real name of company or foundation.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter url picture of image
     * @return urlPicture
     */
    public String getUrlPicture() {
        return urlPicture;
    }

    /**
     * Setter url Picture conform image url of server
     * @param urlPicture is an url saved in the server
     */
    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }
}
