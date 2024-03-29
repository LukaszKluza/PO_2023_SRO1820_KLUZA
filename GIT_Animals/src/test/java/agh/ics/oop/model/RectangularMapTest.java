package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        WorldMap map = new RectangularMap(4,4,1);
        Animal animal1 = new Animal(new Vector2d(2,3));

        try{
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
        boolean case1 = map.canMoveTo(new Vector2d(2,3));
        boolean case2 = map.canMoveTo(new Vector2d(2,2));

        assertFalse(case1);
        assertTrue(case2);
    }

    @Test
    void placeAndObjectAT() {
        WorldMap map = new RectangularMap(4,4,1);
        Animal animal1 = new Animal(new Vector2d(2,3));

        try {
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        assertEquals(animal1,map.objectAt(new Vector2d(2,3)).get());
    }

    @Test
    void move() {
        RectangularMap map = new RectangularMap(4, 4,1);
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(0,0));
        Animal animal4 = new Animal(new Vector2d(4,1));

        try {
            map.place(animal1);
            map.place(animal2);
            map.place(animal3);
            map.place(animal4);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.LEFT);
        map.move(animal2, MoveDirection.BACKWARD);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.BACKWARD);
        map.move(animal4, MoveDirection.BACKWARD);
        map.move(animal3, MoveDirection.RIGHT);
        map.move(animal3, MoveDirection.FORWARD);

        assertEquals(animal1,map.objectAt(new Vector2d(2,4)).get());
        assertEquals(animal2,map.objectAt(new Vector2d(3,1)).get());
        assertEquals(animal3,map.objectAt(new Vector2d(1,0)).get());
        assertEquals(animal4,map.objectAt(new Vector2d(4,0)).get());
    }

    @Test
    void isOccupied() {
        WorldMap map = new RectangularMap(4,4,1);
        Animal animal1 = new Animal(new Vector2d(2,3));

        try{
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
        boolean case1 = map.isOccupied(new Vector2d(2,3));
        boolean case2 = map.isOccupied(new Vector2d(2,2));

        assertTrue(case1);
        assertFalse(case2);
    }
}