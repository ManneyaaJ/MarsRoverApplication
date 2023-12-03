package com.example.MarsRover;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotateClockwise() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Direction rotateAntiClockwise() {
        int index = (ordinal() - 1) % values().length;
        return values()[index < 0 ? index + values().length : index];
    }
}
