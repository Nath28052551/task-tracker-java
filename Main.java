
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
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
                    int taskNum = Integer.parseInt(scanner.nextLine());
                    if (taskNum >= 1 && taskNum <= tasks.size()) {
                        tasks.get(taskNum - 1).markDone();
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("Invalid task number.");
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