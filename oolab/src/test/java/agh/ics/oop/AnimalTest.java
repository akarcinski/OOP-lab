package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void isAt() {
        RectangularMap map = new RectangularMap();
        Animal Jerry = new Animal(map);

        assertTrue(Jerry.isAt(new Vector2d(2,2)));
        assertFalse(Jerry.isAt(new Vector2d(2,3)));
    }
    @Test
    void move() {
        RectangularMap map = new RectangularMap();
        Animal Jerry = new Animal(map);

        assertTrue(Jerry.isAt(new Vector2d(2,2)));

        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(2,4)));

        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(2,4)));

        Jerry.move(MoveDirection.RIGHT);
        assertEquals(Jerry.getOrient(), MapDirection.EAST);

        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(4,4)));

        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(4,4)));

        Jerry.move(MoveDirection.RIGHT);
        assertEquals(Jerry.getOrient(), MapDirection.SOUTH);

        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(4,0)));

        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(4,0)));

        Jerry.move(MoveDirection.RIGHT);
        assertEquals(Jerry.getOrient(), MapDirection.WEST);

        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(0,0)));

        Jerry.move(MoveDirection.FORWARD);
        assertTrue(Jerry.isAt(new Vector2d(0,0)));

        Jerry.move(MoveDirection.RIGHT);
        assertEquals(Jerry.getOrient(), MapDirection.NORTH);

        Jerry.move(MoveDirection.LEFT);
        assertEquals(Jerry.getOrient(), MapDirection.WEST);
        Jerry.move(MoveDirection.LEFT);
        assertEquals(Jerry.getOrient(), MapDirection.SOUTH);
        Jerry.move(MoveDirection.LEFT);
        assertEquals(Jerry.getOrient(), MapDirection.EAST);

    }
}
