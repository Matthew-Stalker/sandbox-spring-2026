package org.example.sandbox.streamapi;

public class FluentApi {


    public static void main(String[] args) {

        Widget widget = new Widget.Builder()
                .withLength(10.0)
                .withWidth(5.0)
                .withHeight(2.0)
                .build();
        System.out.println(widget);

    }

}
