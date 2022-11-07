package agh.ics.oop;

public class Animal {
    private MapDirection orient;
    private Vector2d position;

    @Override
    public String toString() {
        return position.toString() + " " + orient.toString();
    }

    public Animal() {
        this.orient = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
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
        switch (direction) {
            case LEFT ->  orient = orient.previous();
            case RIGHT ->  orient = orient.next();
            case FORWARD ->  x += orient.toUnitVector().getX();
            case BACKWARD ->   y += orient.toUnitVector().opposite().getY();
        }

        if (x > 4)
            x = 4;
        else if (x < 0)
            x = 0;

        if (y > 4)
            y = 4;
        else if (y < 0)
            y = 0;

        position = new Vector2d(x, y);
    }
}
