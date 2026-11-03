
public class Task {
    private String name;
    private boolean isDone;

    
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + name;
    }
        // New constructor: used when loading a task from the file
    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    // One task as a file line, e.g.  0|Buy milk
    public String toFileLine() {
        return (isDone ? "1" : "0") + "|" + name;
    }

    // Turn a file line back into a Task
    public static Task fromFileLine(String line) {
        String[] parts = line.split("\\|", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Bad line: " + line);
        }
        return new Task(parts[1], parts[0].equals("1"));
    }
}