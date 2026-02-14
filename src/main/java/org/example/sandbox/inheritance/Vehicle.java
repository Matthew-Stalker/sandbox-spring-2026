package org.example.sandbox.inheritance;

public abstract class Vehicle implements Conveyance {

    protected static int counter;
    protected int loadCapacity;

    public Vehicle() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public abstract void load();

    public void unload(){
        System.out.println("Unloading vehicle stuff");
    }

}
