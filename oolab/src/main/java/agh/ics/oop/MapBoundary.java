package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
//    private Set<Vector2d> xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
//    private Set<Vector2d> yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public TreeSet<Vector2d> xAxis = new TreeSet<Vector2d>(Comparator.comparing(Vector2d::getX));
    public TreeSet<Vector2d> yAxis = new TreeSet<Vector2d>(Comparator.comparing(Vector2d::getY));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.add(newPosition);
        yAxis.add(newPosition);

        xAxis.remove(oldPosition);
        yAxis.remove(oldPosition);
    }
    public void addPosition(Vector2d position) {
        xAxis.add(position);
        yAxis.add(position);
    }
    public Vector2d getUpperRight() {
        return new Vector2d(xAxis.last().getX(), yAxis.last().getY());
    }
    public Vector2d getLowerLeft() {
        return new Vector2d(xAxis.first().getX(), yAxis.first().getY());
    }
}
