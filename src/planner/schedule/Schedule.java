package planner.schedule;
import planner.TaskException;
import planner.tasks.Task;
import java.time.LocalDate;
import java.util.*;
public class Schedule {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    public void addTask(Task task) {
        taskMap.put(task.getId(),task);
    }
    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }
    public void removeTask(int id) throws TaskException {
        if(!taskMap.containsKey(id)) {
            throw new TaskException("Такой задачи нет");
        }
        taskMap.remove(id);
    }
    public Collection<Task> getTasksForDay(LocalDate localDate){
        Set<Task> tasksForDays = new TreeSet<>(new TaskTime());
        for (Task task: taskMap.values()){
            if(task.appearsIn(localDate)){
                tasksForDays.add(task);
            }
        }
        return tasksForDays;
    }
}