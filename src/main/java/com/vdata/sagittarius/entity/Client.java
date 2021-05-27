package com.vdata.sagittarius.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends AEntity implements IClient {

    @Column(name = "client_state")
    private PersonType personType;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;


    public Client(){}

    public Client(PersonType type, String city1, String street1){
        personType = type;
        city = city1;
        street = street1;
    }

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

    @Override
    public String toString() {
        return "Client " + getPersonType() + "who lives on the " + getStreet() + ", " + getCity();
    }
}
