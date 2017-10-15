package com.uhack.builder.model;

/**
 * Created by nimit on 15/10/17.
 */

public class Todo {
    private String Task, builderID, contractorID, todoID;
    private int complete;
    private long dueDate;

    public Todo(String task, String builderID, String contractorID, String todoID, int complete, long dueDate) {
        Task = task;
        this.builderID = builderID;
        this.contractorID = contractorID;
        this.todoID = todoID;
        this.complete = complete;
        this.dueDate = dueDate;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getBuilderID() {
        return builderID;
    }

    public void setBuilderID(String builderID) {
        this.builderID = builderID;
    }

    public String getContractorID() {
        return contractorID;
    }

    public void setContractorID(String contractorID) {
        this.contractorID = contractorID;
    }

    public String getTodoID() {
        return todoID;
    }

    public void setTodoID(String todoID) {
        this.todoID = todoID;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }
}
