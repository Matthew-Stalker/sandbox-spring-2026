package org.example.sandbox.inheritance;

public class Car extends Vehicle {

    public Car(){
        counter++;
    }

    @Override
    public void load() {
        System.out.println("Loading car stuff");
    }

    @Override
    public void transport() {
        System.out.println("Transporting car stuff");
    }

    @Override
    public void move() {
        System.out.println("Moving car stuff");
    }

    @Override
    public void stop() {
        System.out.println("Stopping car stuff");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turning left car stuff");
    }

    @Override
    public void turnRight() {
        System.out.println("Turning right car stuff");
    }

    @Override
    public void unload(){
        System.out.println("Unloading car stuff");
    }
}
