package com.uhack.builder.model;

import java.util.ArrayList;

/**
 * Created by piyush on 14/10/17.
 */

public class Contractor {
    private String contractorID, contractorName, contractorEMAIL;
    private int skillType;
    private ArrayList<String> workerIDs;

    public Contractor(String contractorID, String contractorName, String contractorEMAIL, int skillType, int pay, ArrayList<String> workerIDs) {
        this.contractorID = contractorID;
        this.contractorName = contractorName;
        this.contractorEMAIL = contractorEMAIL;
        this.skillType = skillType;
        this.workerIDs = workerIDs;
    }

    public String getContractorID() {

        return contractorID;
    }

    public void setContractorID(String contractorID) {
        this.contractorID = contractorID;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorEMAIL() {
        return contractorEMAIL;
    }

    public void setContractorEMAIL(String contractorEMAIL) {
        this.contractorEMAIL = contractorEMAIL;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
        this.skillType = skillType;
    }


    public ArrayList<String> getWorkerIDs() {
        return workerIDs;
    }

    public void setWorkerIDs(ArrayList<String> workerIDs) {
        this.workerIDs = workerIDs;
    }
}
