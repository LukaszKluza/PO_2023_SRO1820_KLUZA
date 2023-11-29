package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> mapGrass = new HashMap<>();

    public GrassField(int grassCount) {
        this.mapVisualizer = new MapVisualizer(this);
        int maxSide = (int) Math.sqrt(grassCount*10);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxSide, maxSide, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) {
            mapGrass.put(grassPosition, new Grass(grassPosition));
            edgeUpdate(grassPosition);
        }
    }
    private void edgeUpdate(Vector2d position){
        lowerLeft = lowerLeft.lowerLeft(position);
        upperRight = upperRight.upperRight(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null || (mapGrass.get(position) != null && mapAnimals.get(position) == null);
    }

    @Override
    public boolean place(Animal element) {
        boolean res = super.place(element);
        if(res){
            edgeUpdate(element.getPosition());
        }
        return res;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal,direction);
        Vector2d newPosition = animal.getPosition();
        edgeUpdate(newPosition);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(mapAnimals.get(position) != null){
            return mapAnimals.get(position);
        }
         return mapGrass.get(position);
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> combinedMap = new HashMap<>(super.getElements());
        combinedMap.putAll(mapGrass);
        return Collections.unmodifiableMap(combinedMap);
    }

}
