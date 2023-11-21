package agh.ics.oop.model;

public class MyString {
    private final String stringContent;
    private MapDirection stringDirection;
    private Integer stringPosition;

    public MyString(String stringContent){
        this(stringContent, null);
    }

    public MyString(String stringContent, Integer stringPosition) {
        this.stringContent = stringContent;
        this.stringDirection = MapDirection.EAST;
        this.stringPosition = stringPosition;
    }

    public MapDirection getStringDirection() {
        return stringDirection;
    }

    public int getStringPosition() {
        return stringPosition;
    }

    public String getStringContent() {
        return stringContent;
    }

    public void setStringPosition(Integer stringPosition) {
        this.stringPosition = stringPosition;
    }

    public void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> stringDirection = stringDirection.next();
            case LEFT -> stringDirection = stringDirection.previous();
            case FORWARD, BACKWARD -> {
                if(this.stringDirection.toUnitVector().getX() != 0){
                    Vector2d moveVector = this.stringDirection.toUnitVector();
                    if (direction == MoveDirection.BACKWARD) {
                        moveVector = moveVector.opposite();
                    }
                    Vector2d newPosition = new Vector2d(this.stringPosition + moveVector.getX(),0);
                    if (validator.canMoveTo(newPosition)) {
                        this.stringPosition = newPosition.getX();
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        return stringContent;
    }
}
