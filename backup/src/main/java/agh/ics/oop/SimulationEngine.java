package agh.ics.oop;

import java.util.*;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;

    SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;

        for(Vector2d vec: positions) {
            Animal animal = new Animal(this.map, vec);
        }
    }

    @Override
    public void run() {
        GrassField map = ( (GrassField)this.map );
        Iterator <Animal> iter = map.getMap().listIterator();
        System.out.println(map);
        for(MoveDirection move: moves) {
            Animal ani = iter.next();
            ani.move(move);
            //map.updateCorners(ani.getPlace());
            if (!iter.hasNext()) {
                iter = map.getMap().listIterator();
                System.out.println(map);
            }
        }
    }
}
