package agh.ics.oop;

import java.util.*;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input) {
       List<MoveDirection> parsed = new ArrayList<>();
       for(String arg: input) {
           arg = arg.toLowerCase(Locale.ROOT);
           switch (arg) {
               case "f" -> parsed.add(MoveDirection.FORWARD);
               case "forward" -> parsed.add(MoveDirection.FORWARD);
               case "b" -> parsed.add(MoveDirection.BACKWARD);
               case "backward" -> parsed.add(MoveDirection.BACKWARD);
               case "r" -> parsed.add(MoveDirection.RIGHT);
               case "right" -> parsed.add(MoveDirection.RIGHT);
               case "l" -> parsed.add(MoveDirection.LEFT);
               case "left" -> parsed.add(MoveDirection.LEFT);
           }
       }

       return parsed.toArray(new MoveDirection[0]);
    }
}
