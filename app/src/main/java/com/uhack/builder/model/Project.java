package com.uhack.builder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush on 14/10/17.
 */

public class Project {
    private String name;
    private String address;
    private int totalBudget;
    private int currentExpenses;
    private String builderID, projectID;
    private ArrayList<String> inventoryIDs,contractorIDs,workerIDs;

    public Project() {

    }

    public Project(String name, String address, int totalBudget, int currentExpenses, String builderID, String projectID, ArrayList<String> inventoryIDs, ArrayList<String> contractorIDs, ArrayList<String> workerIDs) {
        this.name = name;
        this.address = address;
        this.totalBudget = totalBudget;
        this.currentExpenses = currentExpenses;
        this.builderID = builderID;
        this.projectID = projectID;
        this.inventoryIDs = inventoryIDs;
        this.contractorIDs = contractorIDs;
        this.workerIDs = workerIDs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(int currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public String getBuilderID() {
        return builderID;
    }

    public void setBuilderID(String builderID) {
        this.builderID = builderID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public ArrayList<String> getInventoryIDs() {
        return inventoryIDs;
    }

    public void setInventoryIDs(ArrayList<String> inventoryIDs) {
        this.inventoryIDs = inventoryIDs;
    }

    public ArrayList<String> getContractorIDs() {
        return contractorIDs;
    }

    public void setContractorIDs(ArrayList<String> contractorIDs) {
        this.contractorIDs = contractorIDs;
    }

    public ArrayList<String> getWorkerIDs() {
        return workerIDs;
    }

    public void setWorkerIDs(ArrayList<String> workerIDs) {
        this.workerIDs = workerIDs;
    }
}
