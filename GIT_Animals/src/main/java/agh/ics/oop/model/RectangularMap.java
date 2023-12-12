package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap extends AbstractWorldMap{
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    public RectangularMap(int width, int height, int Id) {
        upperRight = new Vector2d(width, height);
        lowerLeft = new Vector2d(0,0);
        this.Id = Id;
        this.mapVisualizer = new MapVisualizer(this);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return lowerLeft.precedes(position) && upperRight.follows(position) && !isOccupied( position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(lowerLeft, upperRight);
    }
}