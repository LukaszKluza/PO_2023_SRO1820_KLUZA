package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
        lowerLeft = new Vector2d(0,0);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return lowerLeft.precedes(position) && upperRight.follows(position) && !isOccupied( position);
    }

    @Override
    public boolean place(Animal element) {
        return super.place(element);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal, direction);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        return super.getElements();
    }

}