package agh.ics.oop;

public class Animal {
    private MapDirection orient;
    private Vector2d position;
    private IWorldMap map;

    @Override
    public String toString() {
        return orient.toString();
    }

    public Animal(IWorldMap map) {
        this.map = map;
        this.orient = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
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

    public Vector2d getPlace() {
        return position;
    }

    public boolean isAt(Vector2d position) {

        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        int x = position.getX();
        int y = position.getY();
        Vector2d step = new Vector2d();
        switch (direction) {
            case LEFT ->  orient = orient.previous();
            case RIGHT ->  orient = orient.next();
            case FORWARD -> step = orient.toUnitVector();
            case BACKWARD ->  step = orient.toUnitVector().opposite();
        }
        x += step.getX();
        y += step.getY();
        Vector2d isAble = new Vector2d(x, y);
        if (map.canMoveTo(isAble))
            position = isAble;
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
}
