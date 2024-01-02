package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

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
        return objectAt(position) == null || (mapGrass.containsKey(position) && !mapAnimals.containsKey(position));
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if(mapAnimals.get(position) != null){
            return mapAnimals.get(position);
        }
         return mapGrass.get(position);
    }
    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> combinedMap = new HashMap<>(super.getElements());
        combinedMap.putAll(mapGrass);
        return Collections.unmodifiableMap(combinedMap);
    }
    @Override
    public Boundary getCurrentBounds() {
        Map<Vector2d, WorldElement> elements = getElements();
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(WorldElement element : elements.values()){
            lowerLeft = lowerLeft.lowerLeft(element.getPosition());
            upperRight = upperRight.upperRight(element.getPosition());
        }
        return new Boundary(lowerLeft, upperRight);
    }

}
