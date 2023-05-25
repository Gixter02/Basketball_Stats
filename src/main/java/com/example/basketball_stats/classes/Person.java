package com.example.basketball_stats.classes;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;


    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Other constructors
     */
    public Person(String firstName, String lastName) {
        this(firstName, lastName, "Random Street", 1234, "Nowhere", LocalDate.of(2000, 1, 1));
    }

    public Person(String firstName, String lastName, String street, Integer postalCode, String city, LocalDate birthDay) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.postalCode = new SimpleIntegerProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.birthday = new SimpleObjectProperty<>(birthDay);
    }

    public Person(Person other) {
        this.firstName = new SimpleStringProperty(other.getFirstName());
        this.lastName = new SimpleStringProperty(other.getLastName());
        this.street = new SimpleStringProperty(other.getStreet());
        this.postalCode = new SimpleIntegerProperty(other.getPostalCode());
        this.city = new SimpleStringProperty(other.getCity());
        this.birthday = new SimpleObjectProperty<>(other.getBirthday());
    }

    /**
     * Getters and setters
     */
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

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
}
