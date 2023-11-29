package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap{
    private final static int MIN_VALUE = Integer.MIN_VALUE;
    private final static int MAX_VALUE = Integer.MAX_VALUE;
    protected Vector2d lowerLeft = new Vector2d(MAX_VALUE, MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(MIN_VALUE, MIN_VALUE);
    protected final Map<Vector2d, Animal> mapAnimals = new HashMap<>();
    protected MapVisualizer mapVisualizer;
    public abstract boolean canMoveTo(Vector2d position);
    @Override
    public boolean place(Animal element) {
        Vector2d position = element.getPosition();
        if(canMoveTo(position)){
            mapAnimals.put(element.getPosition(), element);
            return true;
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(isOccupied(animal.getPosition()) && objectAt(animal.getPosition()).equals(animal)){
            Vector2d oldPosition = animal.getPosition();
            animal.move(direction,this);
            Vector2d newPosition = animal.getPosition();
            mapAnimals.remove(oldPosition);
            System.out.println(animal+newPosition.toString());
            mapAnimals.put(newPosition, animal);
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return mapAnimals.get(position);
    }
    @Override
    public String toString() {
        return this.mapVisualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        return Collections.unmodifiableMap(mapAnimals);
    }
}
