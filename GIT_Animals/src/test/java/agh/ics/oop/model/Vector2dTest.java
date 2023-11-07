package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d vectorA = new Vector2d(1,5);

        String stringA = vectorA.toString();

        assertEquals("(1,5)", stringA);
    }

    @Test
    void precedes() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);
        Vector2d vectorC = new Vector2d(1,3);
        Vector2d vectorD = new Vector2d(4,5);

        boolean precedesAB = vectorA.precedes(vectorB);
        boolean precedesCD = vectorC.precedes(vectorD);

        assertFalse(precedesAB);
        assertTrue(precedesCD);
    }

    @Test
    void follows() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);
        Vector2d vectorC = new Vector2d(1,3);
        Vector2d vectorD = new Vector2d(4,5);

        boolean followsAB = vectorA.follows(vectorB);
        boolean followsCD = vectorC.follows(vectorD);


        assertTrue(followsAB);
        assertFalse(followsCD);
    }

    @Test
    void add() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);

        Vector2d vectorC = vectorA.add(vectorB);

        assertEquals(new Vector2d(2,7), vectorC);
    }

    @Test
    void subtract() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);

        Vector2d vectorC = vectorA.subtract(vectorB);

        assertEquals(new Vector2d(0,3), vectorC);
    }

    @Test
    void upperRight() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);

        Vector2d vectorC = vectorA.upperRight(vectorB);

        assertEquals(new Vector2d(1,5), vectorC);
    }

    @Test
    void lowerLeft() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,2);

        Vector2d vectorC = vectorA.lowerLeft(vectorB);

        assertEquals(new Vector2d(1,2), vectorC);
    }

    @Test
    void opposite() {
        Vector2d vectorA = new Vector2d(1,5);

        Vector2d vectorB = vectorA.opposite();

        assertEquals(new Vector2d(-1,-5), vectorB);
    }

    @Test
    void testEquals() {
        Vector2d vectorA = new Vector2d(1,5);
        Vector2d vectorB = new Vector2d(1,5);

        boolean equals = vectorA.equals(vectorB);

        assertTrue(equals);
    }
}