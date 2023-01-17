package agh.ics.oop;

import java.util.HashMap;


public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected HashMap<Vector2d, AbstractWorldMapElement> map = new HashMap<>();
    //public Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    //public Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public MapBoundary mapBoundary;

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        map.put(newPosition, (Animal)objectAt(oldPosition));
        map.remove(oldPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (objectAt(animal.getPosition()) instanceof Animal)
            throw new IllegalArgumentException(animal.getPosition() + " illegal place");

        if  (isOccupied(animal.getPosition())) {
            map.remove(animal.getPosition());
        }
        map.put(animal.getPosition(), animal);
        animal.addObserver(this);
        mapBoundary.addPosition(animal.getPosition());
        return true;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(mapBoundary.getLowerLeft(), mapBoundary.getUpperRight());
    }

    @Override
    public Object objectAt(Vector2d position) {
        return map.getOrDefault(position, null);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return map.containsKey(position);
    }

    public HashMap getMap() {
        return this.map;
    }


//    public void updateCorners(Vector2d position) {
//        if (position.getX() < lowerLeft.getX() || position.getY() < lowerLeft.getY()) {
//            int x = Math.min(position.getX(), lowerLeft.getX());
//            int y = Math.min(position.getY(), lowerLeft.getY());
//            lowerLeft = new Vector2d(x, y);
//        }
//        if (position.getX() > upperRight.getX() || position.getY() > upperRight.getY()) {
//            int x = Math.max(position.getX(), upperRight.getX());
//            int y = Math.max(position.getY(), upperRight.getY());
//            upperRight = new Vector2d(x, y);
//        }
//    }
}
