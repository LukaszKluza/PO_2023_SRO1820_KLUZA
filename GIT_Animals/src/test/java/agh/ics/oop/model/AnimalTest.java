package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void getAnimalDirection() {
        Animal animal1 =new Animal();

        assertEquals(MapDirection.NORTH, animal1.getAnimalDirection());
    }

    @Test
    void getAnimalVector() {
        Animal animal1 =new Animal();
        Animal animal2 =new Animal(new Vector2d(0,0));

        assertEquals(new Vector2d(2,2), animal1.getAnimalVector());
        assertEquals(new Vector2d(0,0), animal2.getAnimalVector());
    }

    @Test
    void ToString() {
        Animal animal1 =new Animal();
        Animal animal2 =new Animal(new Vector2d(0,0));

        assertEquals("Direction: %s, position: (2,2)".formatted(MapDirection.NORTH.toString()), animal1.toString());
        assertEquals("Direction: %s, position: (0,0)".formatted(MapDirection.NORTH.toString()), animal2.toString());
    }

    @Test
    void isAt() {
        Animal animal1 =new Animal();

        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertFalse(animal1.isAt(new Vector2d(0,0)));
    }

    @Test
    void moveBorder(){
        Animal animal1 =new Animal(new Vector2d(0,0));

        animal1.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(0,0), animal1.getAnimalVector());
    }

    void moveDirection(){
        Animal animal1 =new Animal();

        animal1.move(MoveDirection.LEFT);

        assertEquals(MapDirection.WEST, animal1.getAnimalDirection());
    }
    @Test
    void moveComplex() {
        Animal animal1 =new Animal();
        Animal animal2 =new Animal(new Vector2d(2,3));

        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);

        assertEquals(MapDirection.SOUTH, animal1.getAnimalDirection());
        assertEquals(MapDirection.EAST, animal2.getAnimalDirection());
        assertEquals(new Vector2d(2,3), animal1.getAnimalVector());
        assertEquals(new Vector2d(0,3), animal2.getAnimalVector());
    }
}