package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> mapGrass = new HashMap<>();

    public GrassField(int grassCount, int id) {
        super(id);
        this.mapVisualizer = new MapVisualizer(this);
        GrassGenerate(grassCount);
    }

    private void GrassGenerate(int grassCount) {
        int maxSide = (int) Math.sqrt(grassCount *10);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxSide, maxSide, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) {
            mapGrass.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position).isEmpty() || (mapGrass.containsKey(position) && !mapAnimals.containsKey(position));
    }
    @Override
    public Optional<WorldElement> objectAt(Vector2d position) {
        if(mapAnimals.containsKey(position)){
            return Optional.ofNullable(mapAnimals.get(position));
        }
         return Optional.ofNullable(mapGrass.get(position));
    }
    @Override
    public Map<WorldElement, Vector2d> getElements() {
        Map<WorldElement, Vector2d> swappedMapGrass  =  mapGrass.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        return Stream.concat(super.getElements().entrySet().stream(), swappedMapGrass.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Boundary getCurrentBounds() {
        Map<WorldElement, Vector2d> elements = getElements();
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Vector2d vector2d : elements.values()){
            lowerLeft = lowerLeft.lowerLeft(vector2d);
            upperRight = upperRight.upperRight(vector2d);
        }
        return new Boundary(lowerLeft, upperRight);
    }

}
