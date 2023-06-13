package com.example.basketball_stats.classes;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private String street;
    private Integer postalCode;
    private String city;
    private LocalDate birthday;


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

    public Person(String firstName, String lastName, String street, Integer postalCode, String city, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.birthday = birthday;
    }

    /*
    public Person(Person other) {
        this.firstName = new String(other.getFirstName());
        this.lastName = new String(other.getLastName());
        this.street = new String(other.getStreet());
        this.postalCode = new SimpleIntegerProperty(other.getPostalCode());
        this.city = new String(other.getCity());
        this.birthday = new SimpleObjectProperty<>(other.getBirthday());
    }
    */

    /*
    Getters and setters
     */
    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return postalCode
     */
    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


}
