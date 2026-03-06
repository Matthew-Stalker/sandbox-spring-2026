package org.example.sandbox.gernerics;

public class Driver {

    public static void main(String[] args) {

        Box<Number> box = new Box<>();
        Box<Number> box2 = new Box<>();


        box.setContents(42);
        System.out.println(box);

        box2.setContents(42.0);
        System.out.println(box2);

        Crate<Box<?>> crate = new Crate<>();
        crate.addBox(box);
        crate.addBox(box2);
        //crate.addBox("Hello World");
        System.out.println(crate);

    }
}
