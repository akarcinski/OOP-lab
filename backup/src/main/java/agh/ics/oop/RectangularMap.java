package agh.ics.oop;

import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    RectangularMap() {
        map = new LinkedList<>();
    }

    public List<Animal> getMap() {
        return map;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.getX() < Integer.MAX_VALUE &&
                position.getX() > Integer.MIN_VALUE &&
                position.getY() < Integer.MAX_VALUE &&
                position.getY() > Integer.MIN_VALUE)
            return !isOccupied(position);

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        try {
            for (Animal animal : map)
                if (position.equals(animal.getPlace()))
                    return true;
        } catch (NullPointerException exception) {
            System.out.println(exception);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        try {
            for (Animal ani : map)
                if (ani.isAt(position))
                    return ani;
        } catch (NullPointerException exception) {
            System.out.println(exception);
            return null;
        }
        return null;
    }
}
