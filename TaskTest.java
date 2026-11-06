import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void newTaskIsNotDone() {
        assertFalse(new Task("Study").isDone());
    }

    @Test
    void markDoneSetsDone() {
        Task t = new Task("Study");
        t.markDone();
        assertTrue(t.isDone());
    }

    @Test
    void toFileLineForNotDoneTask() {
        assertEquals("0|Buy milk", new Task("Buy milk").toFileLine());
    }

    @Test
    void toFileLineForDoneTask() {
        assertEquals("1|Buy milk", new Task("Buy milk", true).toFileLine());
    }

    @Test
    void fromFileLineRebuildsTask() {
        Task t = Task.fromFileLine("1|Buy milk");
        assertEquals("Buy milk", t.getName());
        assertTrue(t.isDone());
    }

    @Test
    void nameContainingPipeSurvives() {
        Task t = Task.fromFileLine("0|a|b");
        assertEquals("a|b", t.getName());
    }

    @Test
    void badLineThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> Task.fromFileLine("garbage"));
    }
}