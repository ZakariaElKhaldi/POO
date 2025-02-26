package model;

public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return description + ";" + completed; 
    }

    public static Task fromString(String data) {
        String[] parts = data.split(";");
        if (parts.length == 2) {
            Task task = new Task(parts[0]);
            task.setCompleted(Boolean.parseBoolean(parts[1]));
            return task;
        }
        return null;
    }
}
