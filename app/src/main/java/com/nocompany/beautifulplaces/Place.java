package com.nocompany.beautifulplaces;

public class Place {
    private String place;
    private String description;
    private String oldPrice;
    private String newPrice;
    private String picture;

    public Place(String place, String description, String oldPrice, String newPrice, String picture) {
        this.place = place;
        this.description = description;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.picture = picture;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
