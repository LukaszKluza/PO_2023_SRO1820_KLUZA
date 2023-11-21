package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void canMoveTo() {
        WorldMap<MyString, Integer> textMap = new TextMap();
        MyString string1 = new MyString("GIT");
        textMap.place(string1);

        boolean res = textMap.canMoveTo(new Vector2d(1,0));

        assertFalse(res);
    }

    @Test
    void place() {
        WorldMap<MyString, Integer> textMap = new TextMap();
        MyString string1 = new MyString("GIT");

        textMap.place(string1);

        assertEquals(string1, textMap.objectAt(0));
    }

    @Test
    void move() {
        TextMap textMap  = new TextMap();
        MyString string1 = new MyString("Ala");
        MyString string2 = new MyString("ma");
        MyString string3 = new MyString("sowoniedzwiedzia");
        MyString string4 = new MyString("i");
        MyString string5 = new MyString("wilka");
        Map<Integer, MyString> expected = Map.of(0, string2, 1, string1, 2, string5, 3, string3, 4, string4);

        textMap.place(string1);
        textMap.place(string2);
        textMap.place(string3);
        textMap.place(string4);
        textMap.place(string5);

        textMap.move(string1, MoveDirection.FORWARD);
        textMap.move(string2, MoveDirection.LEFT);
        textMap.move(string2, MoveDirection.LEFT);
        textMap.move(string2, MoveDirection.FORWARD);
        textMap.move(string4, MoveDirection.RIGHT);
        textMap.move(string4, MoveDirection.BACKWARD);
        textMap.move(string5, MoveDirection.BACKWARD);
        textMap.move(string3, MoveDirection.FORWARD);

        Map<Integer, MyString> out = textMap .getElements();
        assertEquals(expected, out);
    }

}