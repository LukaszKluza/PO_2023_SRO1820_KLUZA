package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

abstract class AbstractWorldMap implements WorldMap{
    private final List<MapChangeListener> observers = new ArrayList<>();
    protected final Map<Vector2d, Animal> mapAnimals = new HashMap<>();
    protected MapVisualizer mapVisualizer;
    private final int Id;

    AbstractWorldMap(int id) {
        Id = id;
        registerObserver((worldMap, message) ->
                System.out.println(getCurrentDateTime() + " " + message)
        );
        FileMapDisplay fileMapDisplay = new FileMapDisplay(id);
        registerObserver(fileMapDisplay);
    }

    private static String getCurrentDateTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
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
        Optional<WorldElement> elementOptional = objectAt(animal.getPosition());
        if(isOccupied(animal.getPosition()) && elementOptional.isPresent() && elementOptional.get().equals(animal)){
            Vector2d oldPosition = animal.getPosition();
            animal.move(direction,this);
            Vector2d newPosition = animal.getPosition();
            mapAnimals.remove(oldPosition);
            mapAnimals.put(newPosition, animal);
            mapChanged("Move animal from: " + oldPosition + " to: " + newPosition + " direction: "+ animal.getAnimalDirection());
        }
    }

    @Override
    public Optional<WorldElement> objectAt(Vector2d position) {
        return Optional.ofNullable(mapAnimals.get(position));
    }
    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return this.mapVisualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }
    @Override
    public Map<WorldElement,Vector2d> getElements() {
        return mapAnimals.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
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

    @Override
    public List<Animal> getOrderedAnimals() {
        List<Animal> animalsList = new ArrayList<>(mapAnimals.values());

        animalsList.sort((animal1, animal2) -> {
            if (animal1.getPosition().getX() == animal2.getPosition().getX()) {
                return Integer.compare(animal1.getPosition().getY(), animal2.getPosition().getY());
            }
            return Integer.compare(animal1.getPosition().getX(), animal2.getPosition().getX());
        });
        return animalsList;
    }

}
