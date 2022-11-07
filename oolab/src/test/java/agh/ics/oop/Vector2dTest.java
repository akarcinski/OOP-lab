package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equals() {
        assertTrue(new Vector2d(0,0).equals(new Vector2d(0,0)));
        assertTrue(new Vector2d(0,1).equals(new Vector2d(0,1)));
        assertTrue(new Vector2d(1,0).equals(new Vector2d(1,0)));
        assertFalse(new Vector2d(1,0).equals(new Vector2d(0,1)));
        assertFalse(new Vector2d(0, 1).equals(new Vector2d(1,0)));
        assertFalse(new Vector2d(1,1).equals(new Object()));
    }
    @Test
    void testToString() {
        assertEquals(new Vector2d(1, 2).toString(), "(1,2)");
        assertEquals(new Vector2d(1, 0).toString(), "(1,0)");
    }
    @Test
    void precedes() {
        assertTrue(new Vector2d(1,2).precedes(new Vector2d(2,2)));
        assertTrue(new Vector2d(1,2).precedes(new Vector2d(1,2)));
        assertFalse(new Vector2d(1,2).precedes(new Vector2d(0,2)));
        assertFalse(new Vector2d(1,2).precedes(new Vector2d(1,1)));
    }
    @Test
    void follows() {
        assertTrue(new Vector2d(1,2).follows(new Vector2d(0,1)));
        assertTrue(new Vector2d(1,2).follows(new Vector2d(1,2)));
        assertFalse(new Vector2d(1,2).follows(new Vector2d(2,2)));
        assertFalse(new Vector2d(1,2).follows(new Vector2d(1,3)));
    }
    @Test
    void upperRight() {
        assertEquals(new Vector2d(1,2).upperRight(new Vector2d(2, 1)), new Vector2d(2, 2));
        assertEquals(new Vector2d(2,2).upperRight(new Vector2d(2, 1)), new Vector2d(2, 2));
        assertEquals(new Vector2d(1,2).upperRight(new Vector2d(2, 2)), new Vector2d(2, 2));
        assertEquals(new Vector2d(2,2).upperRight(new Vector2d(2, 2)), new Vector2d(2, 2));
    }
    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(2, 1)), new Vector2d(1, 1));
        assertEquals(new Vector2d(1, 1).lowerLeft(new Vector2d(2, 1)), new Vector2d(1, 1));
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(1, 1)), new Vector2d(1, 1));
        assertEquals(new Vector2d(1, 1).lowerLeft(new Vector2d(1, 1)), new Vector2d(1, 1));
    }
    @Test
    void add() {
        assertEquals(new Vector2d(1, 2).add(new Vector2d(0, 0)), new Vector2d(1, 2));
        assertEquals(new Vector2d(0, 0).add(new Vector2d(1, 2)), new Vector2d(1, 2));
        assertEquals(new Vector2d(0, 0).add(new Vector2d(0,0)), new Vector2d(0,0));
        assertEquals(new Vector2d(1, 2).add(new Vector2d(3,4)), new Vector2d(4,6));
    }
    @Test
    void subtract() {
        assertEquals(new Vector2d(2, 2).subtract(new Vector2d(0, 0)), new Vector2d(2, 2));
        assertEquals(new Vector2d(2, 2).subtract(new Vector2d(1, 0)), new Vector2d(1, 2));
        assertEquals(new Vector2d(2, 2).subtract(new Vector2d(0, 1)), new Vector2d(2, 1));
        assertEquals(new Vector2d(2, 2).subtract(new Vector2d(1, 1)), new Vector2d(1, 1));
    }
    @Test
    void opposite() {
        assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0,0));
        assertEquals(new Vector2d(1, 2).opposite(), new Vector2d(-1,-2));
        assertEquals(new Vector2d(-1, 2).opposite(), new Vector2d(1,-2));
        assertEquals(new Vector2d(1, -2).opposite(), new Vector2d(-1,2));
    }
}
