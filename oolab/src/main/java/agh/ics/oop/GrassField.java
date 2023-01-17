package agh.ics.oop;

public class GrassField extends AbstractWorldMap {
    int numberOfGrass;

    public GrassField(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
        super.mapBoundary = new MapBoundary();
        for (int i = 0; i < numberOfGrass; i++) {
            addGrass();
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.getX() < Integer.MAX_VALUE &&
                position.getX() > Integer.MIN_VALUE &&
                position.getY() < Integer.MAX_VALUE &&
                position.getY() > Integer.MIN_VALUE) {

            Object obj = objectAt(position);
            if (obj == null) {
                //updateCorners(position);
                return true;
            } else if (obj instanceof Grass) {
                return addGrass();
            }

            return !isOccupied(position);
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);

        //updateCorners(position);
    }

    public boolean addGrass() throws IllegalArgumentException{
        boolean possible = false;
        Vector2d possiblePosition = new Vector2d(0, 0);
        int range = (int) (Math.sqrt(10 * numberOfGrass) + 1);

        Vector2d p = new Vector2d(0,1);
        map.put(p, new Grass(p));
        mapBoundary.addPosition(p);

        for (int i = 0; i <= range; i++) {
            for (int j = 0; j <= range; j++) {
                if (!isOccupied(new Vector2d(i, j))) {
                    possible = true;
                    possiblePosition = new Vector2d(i, j);
                    break;
                }
            }
            if (possible)
                break;
        }
        if (!possible)
            throw new IllegalArgumentException("grass can't be added");

        int x = (int) (Math.random() * (Math.sqrt(10 * numberOfGrass) + 1));
        int y = (int) (Math.random() * (Math.sqrt(10 * numberOfGrass) + 1));
        Vector2d position = new Vector2d(x, y);

        for (int i = 0; i < 100; i++) {
            if (isOccupied(position)) {
                x = (int) (Math.random() * (Math.sqrt(10 * numberOfGrass) + 1));
                y = (int) (Math.random() * (Math.sqrt(10 * numberOfGrass) + 1));
                position = new Vector2d(x, y);
            } else {
                map.put(position, new Grass(position));
                mapBoundary.addPosition(position);
                //updateCorners(position);
                return true;
            }
        }

        map.put(possiblePosition, new Grass(possiblePosition));
        mapBoundary.addPosition(possiblePosition);

        return true;
    }
}
