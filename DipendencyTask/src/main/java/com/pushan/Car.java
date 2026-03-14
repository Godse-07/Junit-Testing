package com.pushan;

public class Car {

    private int id;
    private String name;
    private String color;

    public Car(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + ", name='" + name + "', color='" + color + "'}";
    }
}
