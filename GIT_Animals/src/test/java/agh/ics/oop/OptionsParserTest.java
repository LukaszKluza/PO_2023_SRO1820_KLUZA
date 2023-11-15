package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void convertOptions() {
        String[] optionList = {"a", "b", "c", "r", "a", "x", "f", "l"};

        List<MoveDirection> expectedOption = Arrays.asList(MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT);
        List<MoveDirection> actualOption = OptionsParser.convertOptions(optionList);

        assertEquals(expectedOption, actualOption);
    }
}