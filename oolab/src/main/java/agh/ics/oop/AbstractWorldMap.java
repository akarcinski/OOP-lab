package agh.ics.oop;

import java.util.LinkedList;

abstract class AbstractWorldMap implements IWorldMap {
    protected LinkedList<Animal> map;
    protected LinkedList<Grass> gmap;
    public Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);


    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPlace()))
            return false;
        map.add(animal);
        updateCorners(animal.getPlace());
        return true;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    public void updateCorners(Vector2d position) {
        if (position.getX() < lowerLeft.getX() || position.getY() < lowerLeft.getY()) {
            int x = Math.min(position.getX(), lowerLeft.getX());
            int y = Math.min(position.getY(), lowerLeft.getY());
            lowerLeft = new Vector2d(x, y);
        }
        if (position.getX() > upperRight.getX() || position.getY() > upperRight.getY()) {
            int x = Math.max(position.getX(), upperRight.getX());
            int y = Math.max(position.getY(), upperRight.getY());
            upperRight = new Vector2d(x, y);
        }
    }
}
