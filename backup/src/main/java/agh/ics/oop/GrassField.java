package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap{
    int numberOfGrass;
    public GrassField(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
        map = new LinkedList<>();
        gmap = new LinkedList<>();
        for (int i=0; i<numberOfGrass; i++) {
            int x =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
            int y =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
            Vector2d position = new Vector2d(x, y);
            gmap.add(new Grass(position));
            updateCorners(position);
        }
    }
    public List<Animal> getMap() {
        return map;
    }
    public List<Grass> getGMap() {
        return gmap;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.getX() < Integer.MAX_VALUE &&
                position.getX() > Integer.MIN_VALUE &&
                position.getY() < Integer.MAX_VALUE &&
                position.getY() > Integer.MIN_VALUE) {

            Object obj = objectAt(position);
            if (obj == null) {
                updateCorners(position);
                return true;
            }
            else if(obj instanceof Grass) {
                boolean possible = false;
                for (int i=0; i<=(int)(Math.sqrt(10*numberOfGrass)+1); i++) {
                    for (int j=0; j<=(int)(Math.sqrt(10*numberOfGrass)+1); j++) {
                        if (!isOccupied(new Vector2d(i, j))) {
                            possible = true;
                            break;
                        }
                    }
                    if (possible)
                        break;
                }
                if (!possible)
                    return false;

                gmap.remove((Grass) obj);
                int x =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
                int y =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
                while(isOccupied(new Vector2d(x, y))) {
                    x =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
                    y =  (int)(Math.random() * (Math.sqrt(10*numberOfGrass)  + 1));
                }
                Vector2d pos = new Vector2d(x, y);
                Grass grass = new Grass(pos);
                gmap.add(grass);
                updateCorners(pos);
                return true;
            }

            return !isOccupied(position);
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        try {
            for (Animal animal : map)
                if (position.equals(animal.getPlace()))
                    return true;

            for (Grass grass : gmap)
                if (position.equals(grass.getPosition()))
                    return true;

        } catch (NullPointerException exception) {
            System.out.println(exception);
            return true;
        }
        updateCorners(position);
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        try {
            for (Animal ani : map)
                if (ani.isAt(position))
                    return ani;

            for (Grass grass: gmap)
                if (grass.getPosition().equals(position))
                    return grass;

        } catch (NullPointerException exception) {
            System.out.println(exception);
            return null;
        }
        return null;
    }
}
