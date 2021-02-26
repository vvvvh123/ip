package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.task.Event;
import duke.task.Task;

public class EventCommand extends Command {
    private boolean isExit;
    private String fullCommand;
    private static final int EVENT_LENGTH = 6;
    private static final int AT_LENGTH = 3;

    public EventCommand(String fullCommand) {
        this.fullCommand = fullCommand;
        isExit = false;
    }

    public boolean isExit() {
        return isExit;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int index = fullCommand.indexOf("/");
            String description = fullCommand.substring(EVENT_LENGTH, index - 1);
            String at = fullCommand.substring(index + AT_LENGTH).trim();
            Task newTask = new Event(description, at);
            tasks.addTask(newTask);
            ui.printNewTask(newTask, tasks.getTaskCount());
            storage.saveToFile(tasks);
        } catch (StringIndexOutOfBoundsException e) {
            ui.printEmptyDescription("event");
        }
    }
}
