import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private final Path file;

    public TaskStorage(String fileName) {
        this.file = Path.of(fileName);
    }

    public void save(List<Task> tasks) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Task t : tasks) {
            lines.add(t.toFileLine());
        }
        Files.write(file, lines);
    }

    public List<Task> load() throws IOException {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(file)) {
            return tasks;                    // first run: no file yet, start empty
        }
        for (String line : Files.readAllLines(file)) {
            if (!line.isBlank()) {
                tasks.add(Task.fromFileLine(line));
            }
        }
        return tasks;
    }
}