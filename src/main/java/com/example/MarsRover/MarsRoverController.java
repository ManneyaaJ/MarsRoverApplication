package com.example.MarsRover;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverController {
    private List<MarsRover> rovers = new ArrayList<>();
    private boolean isCollision = false;

    public boolean isCollisionExecution() {
        return isCollision;
    }

    public void initializeRover(int x, int y, Direction direction) {
        MarsRover rover = new MarsRover(x, y, direction);
        rovers.add(rover);
    }

    public void executeCommandsForRover(int roverIndex, String commands) {
        if (roverIndex < 0 || roverIndex >= rovers.size()) {
            System.out.println("Invalid rover index.");
            return;
        }

        MarsRover rover = rovers.get(roverIndex);
        executeCommandsSafely(rover, commands);
    }

    private void executeCommandsSafely(MarsRover rover, String commands){
        for (char command : commands.toCharArray()) {
            int initialX = rover.getX();
            int initialY = rover.getY();

            rover.executeCommands(String.valueOf(command));

            // Check for collision
            if (rovers.stream().anyMatch(r -> r != rover && r.getX() == rover.getX() && r.getY() == rover.getY())) {
                System.out.println("Collision detected. Stopping rover.");
                rover.setX(initialX);
                rover.setY(initialY);
                isCollision = true;
                break; // Stop executing commands for this rover
            }
        }
    }
    public List<MarsRover> getRovers() {
        return rovers;
    }

    // Add a method to get a rover by its index
    public MarsRover getRover(int index) {
        if (index < 0 || index >= rovers.size()) {
            throw new IllegalArgumentException("Invalid rover index.");
        }

        return rovers.get(index);
    }
}
