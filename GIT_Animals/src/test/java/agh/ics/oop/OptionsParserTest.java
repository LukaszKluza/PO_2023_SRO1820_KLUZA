package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void convertOptions() {
        String[] option = {"a", "b", "c", "r", "a" ,"x", "f", "l"};

        MoveDirection[] expectedOption =  {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT};

        assertArrayEquals(expectedOption, OptionsParser.convertOptions(option));
    }
}