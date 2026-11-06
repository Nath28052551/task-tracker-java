# Task Tracker (Java)

A simple console-based task tracker built in Java, my first project using Git and GitHub.

## Why I Built This
I wanted to actually learn Git and GitHub by doing, instead of just reading about them. I'm confident with Java basics, but I'd never touched version control or GitHub before this project, so I built something small and useful I could use to practice the real workflow: writing code, committing changes, and pushing to GitHub.

## Features
- Add tasks
- View all tasks with their completion status
- Mark tasks as done
- Tasks are saved to `tasks.txt` and loaded automatically when the program starts
- Exit the program

## How to Run
1. Make sure you have Java installed (`java -version` to check).
2. Clone this repository:
   ```
   git clone https://github.com/Nath28052551/task-tracker-java.git
   ```
3. Navigate into the project folder and compile:
   ```
   cd task-tracker-java
   javac Main.java Task.java TaskStorage.java
   ```
4. Run the program:
   ```
   java Main
   ```

## How Saving Works
Each task is stored as one line in `tasks.txt`: `0|Buy milk` (0 = not done, 1 = done).
If a line in the file is damaged, it is skipped with a warning and the remaining tasks still load.

## Project Structure
- `Task.java`: represents a single task (name + completion status) and converts it to and from a file line
- `TaskStorage.java`: saves and loads the task list from a file
- `Main.java`: handles the menu, user input, and program logic
- `TaskTest.java`, `TaskStorageTest.java`: JUnit 5 tests

## Running the Tests
The project has JUnit 5 tests. In VS Code, open the Testing panel and click Run Tests.
The tests use a temporary folder, so they never touch your real `tasks.txt`.

## What I Learned
- The full Git/GitHub workflow: clone, add, commit, push, and how to recover when local files and GitHub get out of sync
- Object-oriented programming in Java: classes, encapsulation, getters
- Setting up a Java development environment from scratch, including debugging environment variables (PATH, JAVA_HOME)
- Saving and loading data with files, and handling bad data safely
- Writing automated tests with JUnit, and using `.gitignore` to keep personal files out of a repo

## Future Improvements
- Add the ability to delete tasks
- Edit task names