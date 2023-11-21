package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        WorldMap<Animal, Vector2d> map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,3));

        map.place(animal1);
        boolean case1 = map.canMoveTo(new Vector2d(2,3));
        boolean case2 = map.canMoveTo(new Vector2d(2,2));

        assertFalse(case1);
        assertTrue(case2);
    }

    @Test
    void placeAndObjectAT() {
        WorldMap<Animal, Vector2d> map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,3));

        map.place(animal1);

        assertEquals(animal1,map.objectAt(new Vector2d(2,3)));
    }

    @Test
    void move() {
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(0,0));
        Animal animal4 = new Animal(new Vector2d(4,1));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);

        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.LEFT);
        map.move(animal2, MoveDirection.BACKWARD);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.BACKWARD);
        map.move(animal4, MoveDirection.BACKWARD);
        map.move(animal3, MoveDirection.RIGHT);
        map.move(animal3, MoveDirection.FORWARD);

        assertEquals(animal1,map.objectAt(new Vector2d(2,4)));
        assertEquals(animal2,map.objectAt(new Vector2d(3,1)));
        assertEquals(animal3,map.objectAt(new Vector2d(1,0)));
        assertEquals(animal4,map.objectAt(new Vector2d(4,0)));
    }

    @Test
    void isOccupied() {
        WorldMap<Animal, Vector2d> map = new RectangularMap(4,4);
        Animal animal1 = new Animal(new Vector2d(2,3));

        map.place(animal1);
        boolean case1 = map.isOccupied(new Vector2d(2,3));
        boolean case2 = map.isOccupied(new Vector2d(2,2));

        assertTrue(case1);
        assertFalse(case2);
    }
}