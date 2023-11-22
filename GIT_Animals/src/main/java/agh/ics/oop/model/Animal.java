package agh.ics.oop.model;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d animalVector;

    public Animal() {
        this(new Vector2d(2, 2));
    }

    public Animal(Vector2d vector2d) {
        this.animalVector = vector2d;
        this.animalDirection = MapDirection.NORTH;
    }

    public MapDirection getAnimalDirection() {
        return animalDirection;
    }
    public Vector2d getAnimalVector() {
        return animalVector;
    }

    @Override
    public String toString() {
        return switch (animalDirection){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
            };
    }

    public boolean isAt(Vector2d position){
        return this.animalVector.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD, BACKWARD -> {
                Vector2d moveVector = this.animalDirection.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    moveVector = moveVector.opposite();
                }
                Vector2d newPosition = this.animalVector.add(moveVector);
                if (validator.canMoveTo(newPosition)) {
                    this.animalVector = newPosition;
                }
            }
        }
    }
}
