import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TaskActionsTest {

    private List<Task> sample() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("A"));
        tasks.add(new Task("B"));
        tasks.add(new Task("C"));
        return tasks;
    }

    @Test
    void deletesTheChosenTask() {
        List<Task> tasks = sample();
        assertTrue(TaskActions.deleteTask(tasks, 2));
        assertEquals(2, tasks.size());
        assertEquals("A", tasks.get(0).getName());
        assertEquals("C", tasks.get(1).getName());
    }

    @Test
    void deletesFirstTask() {
        List<Task> tasks = sample();
        assertTrue(TaskActions.deleteTask(tasks, 1));
        assertEquals("B", tasks.get(0).getName());
    }

    @Test
    void deletesLastTask() {
        List<Task> tasks = sample();
        assertTrue(TaskActions.deleteTask(tasks, 3));
        assertEquals(2, tasks.size());
    }

    @Test
    void zeroIsInvalid() {
        List<Task> tasks = sample();
        assertFalse(TaskActions.deleteTask(tasks, 0));
        assertEquals(3, tasks.size());
    }

    @Test
    void tooLargeIsInvalid() {
        List<Task> tasks = sample();
        assertFalse(TaskActions.deleteTask(tasks, 4));
        assertEquals(3, tasks.size());
    }

    @Test
    void negativeIsInvalid() {
        List<Task> tasks = sample();
        assertFalse(TaskActions.deleteTask(tasks, -1));
        assertEquals(3, tasks.size());
    }

    @Test
    void emptyListIsInvalid() {
        assertFalse(TaskActions.deleteTask(new ArrayList<>(), 1));
    }
}