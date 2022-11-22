package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {
    @Test
    void parse() {
        String[] input = {"f", "forward", "b", "backward",
                "r", "right", "l", "left", "n"};
        MoveDirection[] output = {MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.LEFT, MoveDirection.LEFT};
        assertArrayEquals(OptionsParser.parse(input), output);
    }
}
