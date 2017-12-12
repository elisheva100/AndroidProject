package com.example.owner.takeandgo.model.entities;

/**
 * Created by Owner on 08/11/2017.
 */

public enum GEARBOX {
    AUTOMATIC("automatic"), MANUAL("manual");

    private String strType;

    GEARBOX(String type) {
        strType = type;
    }

    @Override
    public String toString() {
        return strType;
    }
    }
