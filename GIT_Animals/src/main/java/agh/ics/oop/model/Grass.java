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
    public String title() {
        return "Grass";
    }

    @Override
    public Image toImage() {
        return new Image("grass.png");
    }
}
