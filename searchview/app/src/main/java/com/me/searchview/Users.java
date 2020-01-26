package com.me.searchview;

public class Users {

    private String id;
    private String price;
    private String name;

    public Users() {
    }

    public Users(String id, String name, String price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
