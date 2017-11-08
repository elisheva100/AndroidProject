package com.example.owner.takeandgo.model.entities;

import java.util.Date;

/**
 * Created by Owner on 08/11/2017.
 */

public class Order {
    private int clientNumber;
    private boolean open;
    private int carNumber;
    private Date rentStart;
    private Date rentEnd;
    private double mileageStart;
    private double mileageEnd;
    private boolean gasFilled;
    private double gasLiters;
    private double finalBilling;
    private int orderNumber;
}
