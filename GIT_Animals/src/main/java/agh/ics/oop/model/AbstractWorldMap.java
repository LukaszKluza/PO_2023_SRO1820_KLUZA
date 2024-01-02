package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract class AbstractWorldMap implements WorldMap{
    private final List<MapChangeListener> observers = new ArrayList<>();
    protected final Map<Vector2d, Animal> mapAnimals = new HashMap<>();
    protected MapVisualizer mapVisualizer;
    private final int Id;

    AbstractWorldMap(int id) {
        Id = id;
    }

    public abstract boolean canMoveTo(Vector2d position);
    @Override
    public void place(Animal element) throws PositionAlreadyOccupiedException  {
        Vector2d position = element.getPosition();
        if(canMoveTo(position)){
            mapAnimals.put(element.getPosition(), element);
            mapChanged("Place animal, position: " + position);
        }
        else {
            throw new PositionAlreadyOccupiedException(position);
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(isOccupied(animal.getPosition()) && objectAt(animal.getPosition()).equals(animal)){
            Vector2d oldPosition = animal.getPosition();
            animal.move(direction,this);
            Vector2d newPosition = animal.getPosition();
            mapAnimals.remove(oldPosition);
            mapAnimals.put(newPosition, animal);
            mapChanged("Move animal from: " + oldPosition + " to: " + newPosition + " direction: "+ animal.getAnimalDirection());
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return mapAnimals.get(position);
    }
    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return this.mapVisualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }
    @Override
    public Map<Vector2d, WorldElement> getElements() {
        return Collections.unmodifiableMap(mapAnimals);
    }

    @Override
    public int getId() {
        return Id;
    }

    public void registerObserver(MapChangeListener observer) {
        observers.add(observer);
    }
    public void unregisterObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void mapChanged(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }
}
