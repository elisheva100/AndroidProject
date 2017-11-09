package com.example.owner.takeandgo.model.entities;

/**
 * Created by Owner on 08/11/2017.
 */

public class Client {
    private String firstName;
    private String lastName;
    private String id;//TODO: copy the id algorithm from c# to get legal id.
    private String email;
    private long creditCard;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public Client(String firstName, String lastName, String id, String email, long creditCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.creditCard = creditCard;
    }
}