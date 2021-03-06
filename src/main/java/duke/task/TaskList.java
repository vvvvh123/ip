package duke.task;

import java.util.ArrayList;

/**
 * TaskList is a class used to contain the list of all tasks created by the user.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructor method to create a new TaskList with no tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor method that takes in an ArrayList<Task>.
     * Used to load tasks from the data file.
     *
     * @param tasks ArrayList<Task>.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Takes in a task and adds it to the TaskList.
     *
     * @param t Task.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Takes in an index and removes the corresponding task from the TaskList.
     *
     * @param index Index in the TaskList of the task to remove.
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Returns ordered list of tasks whose description contains the keyword specified.
     *
     * @param keyword String obtained from user's query.
     * @return String ordered list of tasks containing keyword.
     */
    public String getTasksByKeyword(String keyword) {
        String list = "";
        int taskCounter = 1;
        for (Task t: tasks) {
            if (t.getDescription().contains(keyword)) {
                list += ("\t" + taskCounter + ". ");
                list += (t + "\n");
                taskCounter++;
            }
        }
        return list;
    }

    /**
     * Returns a String to represent the tasks in TaskList as an ordered list.
     *
     * @return String that is an ordered list of tasks.
     */
    @Override
    public String toString() {
        String list = "";
        for (int i = 1; i <= tasks.size(); i++) {
            list += ("\t" + i + ". ");
            list += (tasks.get(i - 1) + "\n");
        }
        return list;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public ArrayList<Task> getList() {
        return tasks;
    }
}
