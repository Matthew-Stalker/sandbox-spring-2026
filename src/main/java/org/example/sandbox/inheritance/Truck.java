package org.example.sandbox.inheritance;

public class Truck extends Vehicle{

    public Truck(){
        counter++;
    }

    @Override
    public void load() {
        System.out.println("Loading truck stuff");
    }

    @Override
    public void transport() {

    }

    @Override
    public void move() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
}
