package com.vdata.sagittarius.entity;

public abstract class Client implements Entity {

    private PersonType personType;
    private String city;
    private String street;

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        this.city = city;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
