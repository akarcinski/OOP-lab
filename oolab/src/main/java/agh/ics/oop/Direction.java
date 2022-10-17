package agh.ics.oop;

public enum Direction {
    FORWARD("f"),
    BACKWARD("b"),
    RIGHT("r"),
    LEFT("l");

    private final String dir;

    Direction (String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
    public static Direction[] parse(String[] input) {
        Direction[] enums = new Direction[input.length];
        for(int i = 0; i < input.length; i++) {
            enums[i] = switch (input[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> null;
            };
        }
        return enums;
    }
}
