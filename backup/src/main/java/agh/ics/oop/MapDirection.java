package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        return switch (this) {
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };

    }

    public MapDirection next() {
        return switch (this) {
            case EAST -> MapDirection.SOUTH;
            case WEST -> MapDirection.NORTH;
            case NORTH -> MapDirection.EAST;
            case SOUTH -> MapDirection.WEST;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case EAST -> MapDirection.NORTH;
            case WEST -> MapDirection.SOUTH;
            case NORTH -> MapDirection.WEST;
            case SOUTH -> MapDirection.EAST;
        };
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
        };
    }
}
