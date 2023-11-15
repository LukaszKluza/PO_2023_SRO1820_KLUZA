package agh.ics.oop.model;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d animalVector;

    public Animal() {
        this.animalVector = new Vector2d(2,2);
        this.animalDirection = MapDirection.NORTH;
    }
    public Animal(Vector2d vector2d) {
        this();
        this.animalVector = vector2d;
    }

    public MapDirection getAnimalDirection() {
        return animalDirection;
    }
    public Vector2d getAnimalVector() {
        return animalVector;
    }

    @Override
    public String toString() {
        return "Direction: " + animalDirection + ", position: " + animalVector;
    }

    public boolean isAt(Vector2d position){
        return this.animalVector.equals(position);
    }

    public void move(MoveDirection direction){
        if(direction.equals(MoveDirection.RIGHT)){
            animalDirection=animalDirection.next();
        } else if (direction.equals(MoveDirection.LEFT)) {
            animalDirection=animalDirection.previous();
        }
        else{
            Vector2d moveVector = animalDirection.toUnitVector();
            Vector2d beginningPosition = new Vector2d(0,0);
            Vector2d finalPosition = new Vector2d(4,4);
            if(direction.equals(MoveDirection.BACKWARD)){
                moveVector = moveVector.opposite();
            }
            Vector2d newPosition = animalVector.add(moveVector);
            if(beginningPosition.precedes(newPosition) && finalPosition.follows(newPosition)){
                animalVector = newPosition;
            }
        }
    }
}
