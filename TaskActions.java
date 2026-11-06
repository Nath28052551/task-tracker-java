import java.util.List;

public class TaskActions {

    // number is 1-based, like the numbers shown in "View tasks".
    // Returns true if a task was deleted, false if the number was invalid.
    public static boolean deleteTask(List<Task> tasks, int number) {
        if (number < 1 || number > tasks.size()) {
        return false;               // invalid number: nothing deleted
    }
    tasks.remove(number - 1);            // the list index is one less than the number
    return true; 
    }
}