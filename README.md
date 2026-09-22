# Java Maze Robot Simulation

A Java Swing project that visualizes a robot navigating maze-like grids with obstacles and limited visibility. The project was originally developed in **March 2023** as a **Programming Laboratory I** university course project.

One of the main implementation details is that **Problem 2 solves and traverses the generated maze without using an explicit Stack data structure**. Instead of the conventional stack-based DFS approach, the robot relies on grid-state updates, directional checks, visited/dead-end markings, and controlled backtracking behavior.

## Overview

The application contains two different maze-navigation scenarios:

- **Problem 1 - URL-based maze:** Builds a grid from URL-based input, assigns an entrance and exit, and visualizes the robot's progress while revealing nearby cells. This part uses a `Stack<int[]>` while searching for a route.
- **Problem 2 - Stack-free maze traversal:** Generates a random maze and navigates it **without an explicit stack**. The robot evaluates neighboring cells, marks explored or blocked paths directly in the matrix, detects dead ends, and changes direction to continue toward the exit.

The graphical interface is implemented with Java Swing/AWT. The application also records the robot's visited coordinates in text files during execution.

## Highlight: Maze Solving Without an Explicit Stack

A common way to solve a maze is to use **Depth-First Search (DFS)** with a stack. Each visited position is pushed onto the stack, and when the solver reaches a dead end, previous positions are popped until another possible direction is found.

**Problem 2 takes a different approach.** It does not maintain a separate stack of previously visited maze positions. Instead, navigation information is kept directly in the maze state.

The implementation uses:

- Neighbor-cell inspection to determine possible movement directions
- Matrix values to represent walls, visited cells, candidate paths, and dead ends
- Directional movement rules to advance through the maze
- Dead-end detection based on surrounding cell states
- State updates that allow the robot to return from invalid paths and continue searching
- An `ArrayList` for route-direction preparation rather than a `Stack` for traversal history

In other words, the maze itself acts as part of the robot's navigation memory. This provides an alternative to the more conventional **stack-based DFS maze solver** and was implemented as part of the original 2023 project design.

> **Scope note:** The stack-free approach applies specifically to **Problem 2**. Problem 1 contains a separate route-search implementation that uses Java's `Stack` class.

## Technologies

- Java
- Java Swing / AWT
- NetBeans project structure
- ArrayList and matrix-based state tracking
- Stack-based path search for Problem 1
- Stack-free traversal logic for Problem 2
- HTTP input with `HttpURLConnection`

## Project Structure

```text
.
├── src/proje221/Proje221.java
├── nbproject/
├── docs/Project_Report_March_2023.pdf
├── build.xml
├── manifest.mf
└── README.md
```

## How the Stack-Free Traversal Works

At a high level, Problem 2 follows this flow:

```text
Generate maze
     |
     v
Choose entrance and exit
     |
     v
Inspect neighboring cells
     |
     v
Move to an available path
     |
     v
Update the matrix with the robot's state
     |
     v
Dead end?
  /      \
 No      Yes
 |        |
 v        v
Continue  Mark / change direction
 |        |
 +--------+
     |
     v
Reach exit
```

This means the solver does not depend on a separate LIFO stack for Problem 2. The current maze representation and cell-state transitions provide the information needed for traversal and dead-end handling.

## Running the Project

### NetBeans

1. Clone or download the repository.
2. Open the project folder in NetBeans.
3. Make sure a compatible JDK is configured. The original NetBeans configuration targets Java 17.
4. Run the project using the main class:

```text
proje221.Proje221
```

### Command Line with Ant

If Apache Ant and a compatible JDK are installed:

```bash
ant run
```

## Notes

- The code reflects the original **March 2023** implementation and is preserved primarily as a university project / portfolio archive.
- The original project used absolute Windows paths for `Dosya1.txt` and `Dosya2.txt`. These were changed to relative paths so the repository can run on other machines without exposing a local username or filesystem path.
- Generated build artifacts, NetBeans private configuration, and runtime text outputs are excluded through `.gitignore`.
- Problem 1 depends on an external URL that was used by the original course project. If that endpoint is no longer available, that part of the application may require a local or alternative input source.
- The project intentionally contains two different navigation implementations, making it useful for comparing an explicit stack-based route search with a matrix/state-driven stack-free traversal approach.

## Original Project Report

A cleaned copy of the original March 2023 report is available in:

```text
docs/Project_Report_March_2023.pdf
```

Student ID numbers were removed from the public version of the report.
