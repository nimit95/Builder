package com.uhack.builder.model;

import java.util.ArrayList;

/**
 * Created by piyush on 14/10/17.
 */

public class Project {
    private String name;
    private String address;
    private int totalBudget;
    private int currentExpenses;
    private int builderID;
    private ArrayList<Integer> inventoryIDs,contractorIDs,workerIDs;

    public Project(String name, String address, int totalBudget, int currentExpenses, int builderID, ArrayList<Integer> inventoryIDs, ArrayList<Integer> contractorIDs, ArrayList<Integer> workerIDs) {
        this.name = name;
        this.address = address;
        this.totalBudget = totalBudget;
        this.currentExpenses = currentExpenses;
        this.builderID = builderID;
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

    public int getBuilderID() {
        return builderID;
    }

    public void setBuilderID(int builderID) {
        this.builderID = builderID;
    }

    public ArrayList<Integer> getInventoryIDs() {
        return inventoryIDs;
    }

    public void setInventoryIDs(ArrayList<Integer> inventoryIDs) {
        this.inventoryIDs = inventoryIDs;
    }

    public ArrayList<Integer> getContractorIDs() {
        return contractorIDs;
    }

    public void setContractorIDs(ArrayList<Integer> contractorIDs) {
        this.contractorIDs = contractorIDs;
    }

    public ArrayList<Integer> getWorkerIDs() {
        return workerIDs;
    }

    public void setWorkerIDs(ArrayList<Integer> workerIDs) {
        this.workerIDs = workerIDs;
    }
}
