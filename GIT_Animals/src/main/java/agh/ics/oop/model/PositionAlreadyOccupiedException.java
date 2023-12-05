package agh.ics.oop.model;

public class PositionAlreadyOccupiedException extends Exception{
    public PositionAlreadyOccupiedException(Vector2d position) {
        super(String.format("Position (%d,%d) is already occupied",position.getX(),position.getY()));
    }
}
