package com.ummtask.moses.model;

/**
 * Created by Moses on 18-03-2018.
 */

public class Model {
    private int id;
    private String name;
    private String address;
    private String status;
    private int image;
    private int rating;
    private int alert;
    private int logo;
    private String distance;
    private String offer;


    public Model(int id, String name, String address, String status, int image, int rating,
                     int alert, int logo, String distance, String offer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.image = image;
        this.rating = rating;
        this.alert = alert;
        this.logo = logo;
        this.distance = distance;
        this.offer = offer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public int getImage() {
        return image;
    }

    public int getRating() {
        return rating;
    }

    public int getAlert() {
        return alert;
    }

    public int getLogo() {
        return logo;
    }

    public String getDistance() {
        return distance;
    }

    public String getOffer() {
        return offer;
    }
}
