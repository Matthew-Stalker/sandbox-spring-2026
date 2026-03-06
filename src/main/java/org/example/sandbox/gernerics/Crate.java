package org.example.sandbox.gernerics;

import java.util.ArrayList;
import java.util.List;

public class Crate<T extends Box<?>> {

    List<T> containers;

    public Crate() {
        this.containers = new ArrayList<>();
    }

    public void addBox(T box) {
        this.containers.add(box);
    }

        @Override
        public String toString() {
        final StringBuffer sb = new StringBuffer("Crate{");
        sb.append(containers);
        sb.append('}');
        return sb.toString();
        }

}
