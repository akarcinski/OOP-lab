package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        MoveDirection[] input = OptionsParser.parse(args);

        Animal Jerry = new Animal();
        for(MoveDirection move: input) {
            Jerry.move((move));
        }
        System.out.println(Jerry);
    }
}
