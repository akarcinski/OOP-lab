package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        run( Direction.parse(args) );
        out.println("Koniec");

    }

    public static void run(Direction[] args) {
        for(Direction element: args) {
            String message = switch (element){
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tylu";
                case RIGHT -> "Skreca w prawo";
                case LEFT -> "Skreca w lewo";
                default -> null;
            };
            out.println(message);
        }
    }


}
