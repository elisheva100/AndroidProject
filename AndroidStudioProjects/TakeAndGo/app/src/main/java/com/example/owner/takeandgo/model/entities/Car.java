package com.example.owner.takeandgo.model.entities;

/**
 * Created by Owner on 08/11/2017.
 */

public class Car {
    private int branchNumber;
    private String modelType;
    private double mileage;
    private long number;

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

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

    public Car(int branchNumber, String modelType, double mileage, long number) {
        this.branchNumber = branchNumber;
        this.modelType = modelType;
        this.mileage = mileage;
        this.number = number;
    }
}
