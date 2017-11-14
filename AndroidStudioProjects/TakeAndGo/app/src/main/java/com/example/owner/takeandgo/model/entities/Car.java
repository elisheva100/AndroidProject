package com.example.owner.takeandgo.model.entities;

/**
 * Created by Owner on 08/11/2017.
 */

public class Car {
    private int branchNumber;
    private int modelType;
    private double mileage;
    private long number;

    public Car() {

    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {this.modelType = modelType;}

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Car(int branchNumber, int modelType, double mileage, long number) {
        this.branchNumber = branchNumber;
        this.modelType = modelType;
        this.mileage = mileage;
        this.number = number;
    }
}
