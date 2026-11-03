import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    private static List<Task> loadTasks(TaskStorage storage) {
        try {
            return storage.load();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Could not load saved tasks: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static void saveTasks(TaskStorage storage, List<Task> tasks) {
        try {
            storage.save(tasks);
        } catch (IOException e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TaskStorage storage = new TaskStorage("tasks.txt");
        List<Task> tasks = loadTasks(storage);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Task Tracker ---");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as done");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    tasks.add(new Task(name));
                    saveTasks(storage, tasks);
                    System.out.println("Task added!");
                    break;

                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter task number to mark done: ");
                    try {
                        int taskNum = Integer.parseInt(scanner.nextLine());
                        if (taskNum >= 1 && taskNum <= tasks.size()) {
                            tasks.get(taskNum - 1).markDone();
                            saveTasks(storage, tasks);
                            System.out.println("Task marked as done!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number.");
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}