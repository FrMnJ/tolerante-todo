package com.todo;

public class Tarea {
    private String title;
    private String description; 
    private Priority priority;
    private Boolean done;

    public Tarea(String title, String description, Priority priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.done = false;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
