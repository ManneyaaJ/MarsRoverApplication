# Mars Rover Application

## Description
This Java application simulates the movement of Mars rovers on a grid based on a set of initial positions and command sequences. It uses the Spring Boot framework for execution.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Collision Detection](#collision-detection)
- [Command-Line Arguments](#command-line-arguments)
- [Sample Commands](#sample-commands)

## Prerequisites
- Java (JDK 8 or later)
- Maven (for building the project)
- Spring Boot

## Getting Started
1. Clone the repository.
2. Build the project using Maven: `mvn clean install`
3. Run the application: `java -jar target/MarsRover-0.0.1-SNAPSHOT.jar [command-line-arguments]`

## Usage
The application takes a series of command-line arguments to initialize and control multiple Mars rovers.

## Collision Detection
The application performs collision detection to check if rovers collide during their movement.
If a collision is detected, the affected rover's position is reset to its position right before collision, and further execution for that rover is stopped.

## Command-Line Arguments
- The number of arguments must be even.
- Each pair of arguments represents the initial position and command sequence for a rover.
- The initial position is provided as a comma-separated string: `x,y,direction` (e.g., `2,3,NORTH`).
- The command sequence is a string of commands (e.g., `f,r,f,b`).

## Sample Commands
- For a Single Rover:
`java -jar target/MarsRover-0.0.1-SNAPSHOT.jar "5,4,NORTH" "f,f,r"`
- For Multiple Rovers:
`java -jar target/MarsRover-0.0.1-SNAPSHOT.jar "1,1,NORTH" "f,r" "1,4,SOUTH" "f,f,r" "5,1,EAST" "f,r"`

