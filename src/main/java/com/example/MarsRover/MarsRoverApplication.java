package com.example.MarsRover;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsRoverApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MarsRoverApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            if (args.length % 2 != 0) {
                throw new IllegalArgumentException("Invalid number of command-line arguments.");
            }

            MarsRoverController roverController = new MarsRoverController();

            for (int i = 0; i < args.length; i += 2) {
                String[] initialPosition = args[i].split(",");
                int initialX = Integer.parseInt(initialPosition[0]);
                int initialY = Integer.parseInt(initialPosition[1]);
                Direction initialDirection = Direction.valueOf(initialPosition[2]);

                roverController.initializeRover(initialX, initialY, initialDirection);
            }

            for (int i = 0; i < args.length; i += 2) {
                roverController.executeCommandsForRover(i / 2, args[i + 1]);
                MarsRover rover = roverController.getRover(i / 2);
                System.out.println("Final Coordinate for Rover " + (i / 2 + 1) + ": " + rover.getX() + ", " + rover.getY());
                System.out.println("Final Direction for Rover " + (i / 2 + 1) + ": " + rover.getDirection());
//                if (roverController.isCollisionExecution()) {
//                    System.out.println("Further execution stopped due to collision.");
//                    break;  // Stop processing other rovers
//                }
            }
        } catch (Exception e) {
            System.err.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
