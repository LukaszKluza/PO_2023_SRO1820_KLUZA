package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    Map<Vector2d, Animal> elements = new HashMap<>();
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight;
    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return lowerLeft.precedes(position) && upperRight.follows(position) && !isOccupied( position);
    }

    @Override
    public boolean place(Animal element) {
        Vector2d position = element.getAnimalVector();
        if(canMoveTo(position)){
            elements.put(element.getAnimalVector(), element);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(elements.containsValue(animal)){
            Vector2d oldPosition = animal.getAnimalVector();
            animal.move(direction,this);
            Vector2d newPosition = animal.getAnimalVector();
            elements.remove(oldPosition);
            elements.put(newPosition, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return elements.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (isOccupied(position)){
            return elements.get(position);
        }
        return null;
    }
    public Map<Vector2d, Animal> getElements() {
        return elements;
    }
    @Override
    public String toString() {
        return this.mapVisualizer.draw(lowerLeft, upperRight);
    }
}
