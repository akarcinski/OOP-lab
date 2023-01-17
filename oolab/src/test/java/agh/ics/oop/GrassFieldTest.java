package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void canMoveTo() {
        GrassField grassField = new GrassField(0);
        Animal Jerry = new Animal(grassField, new Vector2d(2,0));
        Animal Tom = new Animal(grassField, new Vector2d(1,0));
        grassField.map.put(new Vector2d(0,0) ,new Grass(new Vector2d(0,0)));
        assertFalse(grassField.canMoveTo(new Vector2d(2,0)));
        assertTrue(grassField.canMoveTo(new Vector2d(0,0)));
        Object obj = grassField.objectAt(new Vector2d(-1,-1));
        assertNull(obj);
    }

    @Test
    public void isOccupied() {
        GrassField grassField = new GrassField(0);
        grassField.map.put(new Vector2d(0,0), new Grass(new Vector2d(0,0)));
        Animal Jerry = new Animal(grassField, new Vector2d(2,0));

        assertTrue(grassField.isOccupied(new Vector2d(0,0)));
        assertFalse(grassField.isOccupied(new Vector2d(1,0)));
        assertTrue(grassField.isOccupied(new Vector2d(2,0)));
    }

    @Test
    public void objectAt() {
        GrassField grassField = new GrassField(0);
        Animal Tom = new Animal(grassField, new Vector2d(1,0));
        grassField.map.put(new Vector2d(0,0), new Grass(new Vector2d(0,0)));

        Object grass = grassField.objectAt(new Vector2d(0, 0));
        Object animal = grassField.objectAt(new Vector2d(1, 0));
        Object NULL = grassField.objectAt(new Vector2d(-1, -1));

        assert (grass instanceof Grass);
        assert (animal instanceof Animal);
        assertNull(NULL);
    }
}
