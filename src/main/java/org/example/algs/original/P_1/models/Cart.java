package org.example.algs.original.P_1.models;

import java.util.List;

public class Cart {

    private int id;
    private List<Box> boxes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }
}
