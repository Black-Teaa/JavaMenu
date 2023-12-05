package com.example.javamenu.domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String description;
    private String ingredients;
    private String pic;
    private double price;
    private int time;
    private int energy;
    private int numberinCart;

    public FoodDomain(String title, String description, String ingredients, String pic, double price, int time, int energy) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.pic = pic;
        this.price = price;
        this.time = time;
        this.energy = energy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getPicUrl() {
        return pic;
    }

    public void setPicUrl(String picUrl) {
        this.pic = picUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getNumberinCart() {
        return numberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        this.numberinCart = numberinCart;
    }

}
