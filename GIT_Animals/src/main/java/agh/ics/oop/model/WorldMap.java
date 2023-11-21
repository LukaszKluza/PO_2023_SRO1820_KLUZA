package agh.ics.oop.model;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap<T,P> extends MoveValidator {

    boolean place(T element);
    void move(T elements,MoveDirection direction);
    boolean isOccupied(P position);
    T objectAt(P position);
}