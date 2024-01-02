package agh.ics.oop.model;

import javafx.scene.image.Image;

public class Grass implements WorldElement{
    private final Vector2d grassPosition;

    public Grass(Vector2d position) {
        this.grassPosition = position;
    }

    @Override
    public Vector2d getPosition() {
        return grassPosition;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public Image toImage() {
        return new Image("C:\\Users\\Lenovo\\Desktop\\PO\\PO_2023_SRO1820_KLUZA\\GIT_Animals\\images\\grass.png");
    }
}
