package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moves;
    private GrassField map;
    private Vector2d[] positions;
    private App app;
    private int delay = 500;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions, App app) {
        this.moves = moves;
        this.map = (GrassField) map;
        this.positions = positions;
        this.app = app;
        for(Vector2d vec: positions) {
            Animal animal = new Animal(this.map, vec);
        }
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }

    @Override
    public void run(){
        //GrassField map = ( (GrassField)this.map );
        int id = 0;
        int n = positions.length;

        try {
            Thread.sleep(delay);
            System.out.println(map);

            for(MoveDirection move: moves) {
                Vector2d pos = positions[id];
                if (map.objectAt(pos) instanceof Animal) {
                    Animal ani = ((Animal)(map.getMap().get(pos)));
                    ani.move(move);
                    //map.mapBoundary.positionChanged(positions[id], ani.position);
                    positions[id] = ani.getPosition();
                    //System.out.println(ani.position);
                }
                //map.updateCorners(ani.getPosition());
                id++;

                if (id == n) {
                    id %= n;
                    //System.out.println(map.mapBoundary.getLowerLeft());
                    //System.out.println(map.mapBoundary.getUpperRight());

                    System.out.println(map);
                    app.refresh();
                    Thread.sleep(delay);
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.getMessage();
        }


    }
}
