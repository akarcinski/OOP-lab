package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void isOccupied() {
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Animal Jerry = new Animal(rectangularMap, new Vector2d(2,0));

        assertFalse(rectangularMap.isOccupied(new Vector2d(1,0)));
        assertTrue(rectangularMap.isOccupied(new Vector2d(2,0)));
    }

    @Test
    void canMoveTo() {
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Animal Jerry = new Animal(rectangularMap, new Vector2d(2,0));
        Animal Tom = new Animal(rectangularMap, new Vector2d(1,0));

        assertFalse(rectangularMap.canMoveTo(new Vector2d(2,0)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(5,0)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(0,5)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(-1,0)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(0,-1)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(0,0)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(4,4)));
    }


    @Test
    void objectAt() {
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Animal Tom = new Animal(rectangularMap, new Vector2d(1,0));

        Object animal = rectangularMap.objectAt(new Vector2d(1, 0));
        Object NULL = rectangularMap.objectAt(new Vector2d(-1, -1));

        assert (animal instanceof Animal);
        assertNull(NULL);
    }
}
