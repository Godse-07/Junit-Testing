package com.pushan;

public class Bike {

    private int id;
    private String name;
    private String color;

    public Bike(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bike{id=" + id + ", name='" + name + "', color='" + color + "'}";
    }
}
