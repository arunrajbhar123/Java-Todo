public class Task {
    private String task;
    private boolean isCompleted;

    public Task(String task) {
        this.task = task;
        this.isCompleted = false;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return ((isCompleted ? "[X] " : "[] ") + task);
    }
}
