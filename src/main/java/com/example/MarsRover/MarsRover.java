package com.example.MarsRover;

public class MarsRover {
    private int x;
    private int y;
    private Direction direction;

    public MarsRover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'r':
                    rotateClockwise();
                    break;
                case 'l':
                    rotateAntiClockwise();
                    break;
                default:
                    // Ignore unknown commands
                    break;
            }
        }
    }

    public void moveForward() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }
    }

    public void moveBackward() {
        switch (direction) {
            case NORTH:
                y--;
                break;
            case EAST:
                x--;
                break;
            case SOUTH:
                y++;
                break;
            case WEST:
                x++;
                break;
        }
    }

    public void rotateClockwise() {
        direction = direction.rotateClockwise();
    }

    public void rotateAntiClockwise() {
        direction = direction.rotateAntiClockwise();
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }
}
