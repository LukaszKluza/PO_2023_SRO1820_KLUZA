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

        assertEquals(new Vector2d(2,2), animal1.getPosition());
        assertEquals(new Vector2d(0,0), animal2.getPosition());
    }

    @Test
    void ToString() {
        Animal animal1 =new Animal();
        Animal animal2 =new Animal(new Vector2d(0,0));

        assertEquals("N", animal1.toString());
        assertEquals("N", animal2.toString());
    }

    @Test
    void isAt() {
        Animal animal1 =new Animal();

        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertFalse(animal1.isAt(new Vector2d(0,0)));
    }

    MoveValidator validator = new RectangularMap(4,4,1);
    @Test
    void moveBorder(){
        Animal animal1 =new Animal(new Vector2d(0,0));

        animal1.move(MoveDirection.BACKWARD,validator);

        assertEquals(new Vector2d(0,0), animal1.getPosition());
    }
    @Test
    void moveDirection(){
        Animal animal1 =new Animal();

        animal1.move(MoveDirection.LEFT,validator);

        assertEquals(MapDirection.WEST, animal1.getAnimalDirection());
    }
    @Test
    void moveComplex() {
        Animal animal1 =new Animal();
        Animal animal2 =new Animal(new Vector2d(2,3));

        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.LEFT,validator);
        animal1.move(MoveDirection.BACKWARD,validator);

        animal2.move(MoveDirection.RIGHT,validator);
        animal2.move(MoveDirection.BACKWARD,validator);
        animal2.move(MoveDirection.BACKWARD,validator);

        assertEquals(MapDirection.SOUTH, animal1.getAnimalDirection());
        assertEquals(MapDirection.EAST, animal2.getAnimalDirection());
        assertEquals(new Vector2d(2,3), animal1.getPosition());
        assertEquals(new Vector2d(0,3), animal2.getPosition());
    }
}