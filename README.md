# SRTFJava

SRTFJava is a Java-based application that demonstrates the Shortest Remaining Time First (SRTF) CPU scheduling algorithm with a Gantt chart. It is designed for Java-compatible IDEs and requires a compatible Java Runtime Environment (JRE) to run.

## Overview

Shortest Remaining Time First (SRTF) is a preemptive CPU scheduling algorithm. It selects the process with the shortest remaining burst time among the available processes. If a new process arrives with a shorter remaining time than the currently running process, the CPU switches to that process.

SRTFJava is intended to help students understand CPU scheduling through a Gantt chart that visualizes process execution.

## Features

- Shortest Remaining Time First CPU scheduling
- Gantt chart visualization
- Preemptive scheduling demonstration
- Java-based implementation
- Suitable for learning operating system concepts

*Specific functionality depends on the implementation in the source code.*

## Requirements

- Compatible Java Runtime Environment (JRE)
- Java-compatible IDE, such as Eclipse, IntelliJ IDEA, or NetBeans
- Java Development Kit (JDK) if compilation is required
- Project source files

## Installation

1. Download and install a compatible Java runtime from the official website: https://www.java.com/
2. Install a Java-compatible IDE if needed.
3. Download or clone this repository.
4. Open the project in your IDE.
5. Configure the Java environment if required.
6. Run the application's main class.

## Running the Project

Open the project in your Java-compatible IDE and run its main class.

If the project contains a standalone source file named `SRTFJava.java`, you can compile and run it from a terminal:

```bash
javac SRTFJava.java
java SRTFJava
```

These commands assume that the JDK is installed and the source file contains the application's entry point. Adjust the filename or commands if your project uses a different structure.

## How SRTF Works

1. Identify the processes that have arrived and are ready to execute.
2. Select the process with the shortest remaining burst time.
3. Preempt the running process if another available process has a shorter remaining time.
4. Continue until all processes finish.
5. Display the execution sequence using a Gantt chart.

## Project Information

- **Project Name:** SRTFJava
- **Algorithm:** Shortest Remaining Time First
- **Scheduling Type:** Preemptive
- **Language:** Java
- **Visualization:** Gantt Chart
- **Developer:** Ichiro Yamazaki
- **Build Date:** January 2024

## Disclaimer

This project is intended for educational purposes. Actual scheduling behavior and supported inputs depend on the implementation in the source code.

## License

No license has been specified. All rights remain with the author unless otherwise stated.
