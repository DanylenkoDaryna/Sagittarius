package com.vdata.sagittarius.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsuredPerson extends AEntity implements Serializable {

    private String firstName;
    private String midName;
    private String surname;
    private LocalDate birthday;
    private double personalCost;

    private Contract contract;

    /**
     * Constructs a new Insured Person without parameters
     * Used for avoiding nullPointerExeption
     */
    public InsuredPerson() {
    }

    /**
     * Overrided method toString() that prints the main info about object InsuredPerson in readable state
     * @return String with all the attributes of class InsuredPerson: FIO, date of birth, personal cost of Insurance
     */
    @Override
    public String toString() {

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "id: " + this.getId() + "\tFIO:" +  outFIO()
                + "\tCost:" + this.getPersonalCost()
                + "\tBirthday:" + this.getBirthday().format(form);

    }


    /**
     * Method for returning Insured person`s FIO in type "Ivanov O.O."
     * @return String with all the attributes of FIO
     */

    private String outFIO() {

        return getSurname() + " " + getFirstName().charAt(0)+"." + getMidName().charAt(0)+".";

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getPersonalCost() {
        return personalCost;
    }

    public void setPersonalCost(double personalCost) {
        this.personalCost = personalCost;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
