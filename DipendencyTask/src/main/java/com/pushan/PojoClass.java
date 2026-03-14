package com.pushan;

public class PojoClass {
    private Bike bike;
    private Car car;

    public PojoClass(Bike bike, Car car) {
        this.bike = bike;
        this.car = car;
    }

    public void show() {
        System.out.println("Bike Details: " + bike);
        System.out.println("Car Details: " + car);
    }

}
