package agh.ics.oop;

import java.util.*;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input) {
       List<MoveDirection> parsed = new ArrayList<>();
       for(String arg: input) {
           arg = arg.toLowerCase(Locale.ROOT);
           switch (arg) {
               case "f",  "forward"-> parsed.add(MoveDirection.FORWARD);
               case "b", "backward" -> parsed.add(MoveDirection.BACKWARD);
               case "r", "right" -> parsed.add(MoveDirection.RIGHT);
               case "l", "left" -> parsed.add(MoveDirection.LEFT);
           }
       }

       return parsed.toArray(new MoveDirection[0]);
    }
}
