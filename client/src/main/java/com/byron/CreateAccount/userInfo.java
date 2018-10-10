package com.byron.CreateAccount;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class userInfo {

    private final StringProperty userName;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty password;

    public userInfo(String firstName, String lastName, String userName, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
    }
    //----------------------Accessors & Mutators -------------------------------//
    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

}