import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class TaskStorageTest {

    @TempDir
    Path tempDir;   // a temporary folder, deleted after each test

    @Test
    void loadingMissingFileGivesEmptyList() throws IOException {
        TaskStorage storage = new TaskStorage(tempDir.resolve("tasks.txt").toString());
        assertTrue(storage.load().isEmpty());
    }

    @Test
    void saveThenLoadKeepsTasks() throws IOException {
        TaskStorage storage = new TaskStorage(tempDir.resolve("tasks.txt").toString());
        storage.save(List.of(new Task("Study", true), new Task("Sleep", false)));

        List<Task> loaded = storage.load();

        assertEquals(2, loaded.size());
        assertEquals("Study", loaded.get(0).getName());
        assertTrue(loaded.get(0).isDone());
        assertEquals("Sleep", loaded.get(1).getName());
        assertFalse(loaded.get(1).isDone());
    }

    @Test
    void badLineIsSkippedAndGoodLinesLoad() throws IOException {
        Path file = tempDir.resolve("tasks.txt");
        Files.write(file, List.of("1|Study", "garbage", "0|Sleep"));

        List<Task> loaded = new TaskStorage(file.toString()).load();

        assertEquals(2, loaded.size());
    }
}