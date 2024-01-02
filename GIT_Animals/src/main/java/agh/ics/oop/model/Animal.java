package agh.ics.oop.model;

import javafx.scene.image.Image;

public class Animal implements WorldElement {
    private MapDirection animalDirection;
    private Vector2d animalVector;

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public Animal(Vector2d vector2d) {
        this.animalVector = vector2d;
        this.animalDirection = MapDirection.NORTH;
    }

    public MapDirection getAnimalDirection() {
        return animalDirection;
    }
    @Override
    public Vector2d getPosition() {
        return animalVector;
    }

    @Override
    public String toString() {
        return switch (animalDirection){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
            };
    }

    @Override
    public Image toImage() {
        String path = switch (animalDirection){
            case EAST -> "C:\\Users\\Lenovo\\Desktop\\PO\\PO_2023_SRO1820_KLUZA\\GIT_Animals\\images\\east.png";
            case WEST -> "C:\\Users\\Lenovo\\Desktop\\PO\\PO_2023_SRO1820_KLUZA\\GIT_Animals\\images\\west.png";
            case NORTH -> "C:\\Users\\Lenovo\\Desktop\\PO\\PO_2023_SRO1820_KLUZA\\GIT_Animals\\images\\north.png";
            case SOUTH -> "C:\\Users\\Lenovo\\Desktop\\PO\\PO_2023_SRO1820_KLUZA\\GIT_Animals\\images\\south.png";
        };
        return new Image(path);
    }

    public boolean isAt(Vector2d position){
        return this.animalVector.equals(position);
    }

    void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD, BACKWARD -> {
                Vector2d moveVector = this.animalDirection.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    moveVector = moveVector.opposite();
                }
                Vector2d newPosition = this.animalVector.add(moveVector);
                if (validator.canMoveTo(newPosition)) {
                    this.animalVector = newPosition;
                }
            }
        }
    }
}
