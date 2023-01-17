package agh.ics.oop;

import java.util.LinkedList;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orient;
    private IWorldMap map;
    private LinkedList<IPositionChangeObserver> observers = new LinkedList<>();

    @Override
    public String toString() {
        return orient.toString();
    }

    public Animal(IWorldMap map) {
        this.map = map;
        this.orient = MapDirection.NORTH;
        this.position = new Vector2d(-1, 2);
        map.place(this);
    }

    public Animal(IWorldMap map, Vector2d position) {
        this.map = map;
        this.position = position;
        this.orient = MapDirection.NORTH;
        map.place(this);
    }

    public MapDirection getOrient() {
        return orient;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        int x = position.getX();
        int y = position.getY();
        Vector2d step = new Vector2d();
        switch (direction) {
            case LEFT -> orient = orient.previous();
            case RIGHT -> orient = orient.next();
            case FORWARD -> step = orient.toUnitVector();
            case BACKWARD -> step = orient.toUnitVector().opposite();
        }
        x += step.getX();
        y += step.getY();
        Vector2d isAble = new Vector2d(x, y);
        if (map.canMoveTo(isAble)) {
            positionChanged(position, isAble);
            position = isAble;
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final Animal other = (Animal) obj;
        return (this.position.equals(other.position));
    }

    @Override
    public String getImagePath() {
        switch (orient) {
            case NORTH: return "src/main/resources/up.jpg";
            case SOUTH: return "src/main/resources/down.jpg";
            case EAST: return "src/main/resources/right.jpg";
            case WEST: return "src/main/resources/left.png";
            default: return "src/main/resources/up.jpg";
        }
    }
}
