package agh.ics.oop.model;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        WorldMap map = new GrassField(10);
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
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,3));

        try{
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        assertEquals(animal1,map.objectAt(new Vector2d(2,3)));
    }
    @Test
    void move() {
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,3));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(0,0));
        Animal animal4 = new Animal(new Vector2d(4,1));

        try{
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
        map.move(animal3, MoveDirection.LEFT);
        map.move(animal3, MoveDirection.FORWARD);
        map.move(animal4, MoveDirection.BACKWARD);


        assertEquals(animal1,map.objectAt(new Vector2d(2,5)));
        assertEquals(animal2,map.objectAt(new Vector2d(3,1)));
        assertEquals(animal3,map.objectAt(new Vector2d(-1,0)));
        assertEquals(animal4,map.objectAt(new Vector2d(4,-1)));
    }

    @Test
    void isOccupied() {
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,3));

        try{
            map.place(animal1);
        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        boolean case1 = map.isOccupied(new Vector2d(2,3));
        assertTrue(case1);
    }
}