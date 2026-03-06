package org.example.sandbox.streamapi;

import java.util.Objects;

public class Widget {

    private double length;
    private double width;
    private double height;

    // Private constructor so only the Builder can instantiate it
    private Widget(Builder builder) {
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
    }

    public Widget() {}

    // Getters and Setters
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    // Static Builder Class
    public static class Builder {
        private double length;
        private double width;
        private double height;

        public Builder withLength(double length) {
            this.length = length;
            return this;
        }

        public Builder withWidth(double width) {
            this.width = width;
            return this;
        }

        public Builder withHeight(double height) {
            this.height = height;
            return this;
        }

        public Widget build() {
            return new Widget(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Widget widget = (Widget) o;
        return Double.compare(length, widget.length) == 0 &&
                Double.compare(width, widget.width) == 0 &&
                Double.compare(height, widget.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, height);
    }

    @Override
    public String toString() {
        return "Widget{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}