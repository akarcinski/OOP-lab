package agh.ics.oop;

public abstract class AbstractWorldMapElement{ //implements IMapElement {
    protected Vector2d position;

    abstract public String getImagePath();
//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return false;
//    }

    public Vector2d getPosition() {
        return position;
    }
}
