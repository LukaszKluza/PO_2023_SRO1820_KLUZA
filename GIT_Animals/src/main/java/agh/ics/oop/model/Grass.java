package agh.ics.oop.model;

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
}
