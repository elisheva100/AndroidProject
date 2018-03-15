package com.example.owner.takeandgo.model.entities;

/**
 * Created by Owner on 08/11/2017.
 * The class represents branch
 */

public class Branch {
    private Adress adress;
    private int parking;
    private int branchNumber;

    public Branch() {
    }

    //set and get:
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public Branch(Adress adress, int parking, int branchNumber) {
        this.adress = adress;
        this.parking = parking;
        this.branchNumber = branchNumber;
    }


}
