package com.uhack.builder.model;

import java.util.ArrayList;

/**
 * Created by piyush on 14/10/17.
 */

public class Contractor {
    private String contractorID, Name, email,address;
    private int skillType;
    private long mobile;
    private ArrayList<String> workerIDs;

    public Contractor(String contractorID, String name, String email, String address, int skillType, long mobile, ArrayList<String> workerIDs) {
        this.contractorID = contractorID;
        Name = name;
        this.email = email;
        this.address = address;
        this.skillType = skillType;
        this.mobile = mobile;
        this.workerIDs = workerIDs;
    }

    public String getContractorID() {

        return contractorID;
    }

    public void setContractorID(String contractorID) {
        this.contractorID = contractorID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
        this.skillType = skillType;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public ArrayList<String> getWorkerIDs() {
        return workerIDs;
    }

    public void setWorkerIDs(ArrayList<String> workerIDs) {
        this.workerIDs = workerIDs;
    }

    public Contractor(){}
}
