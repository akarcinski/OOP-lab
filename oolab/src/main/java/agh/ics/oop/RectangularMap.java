package agh.ics.oop;

import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    int width;
    int height;
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.getX() <= width &&
                position.getX() >= 0 &&
                position.getY() <= height &&
                position.getY() >= 0)
            return !isOccupied(position);

        return false;
    }


}
