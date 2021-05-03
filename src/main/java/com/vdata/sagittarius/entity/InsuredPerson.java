package com.vdata.sagittarius.entity;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class InsuredPerson implements Serializable, IEntity {


    private int uniqueNum;
    private PhysicalClient client;
    private Contract contract;
    private double personalCost;

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
        return "id: " + this.getId() + "\tFIO:" + outFIO(this.getClient()) +
                "\tType:" +this.getClient().getPersonType().toString() + "\tCost:" + this.getPersonalCost();

    }


    /**
     * Method for returning Insured person`s FIO in type "Ivanov O.O."
     * @return String with all the attributes of FIO
     */

    public String outFIO(PhysicalClient client) {

        return client.getSurname() + " " + client.getFirstName().charAt(0)+"."+client.getMidName().charAt(0)+".";

    }

    public int getUniqueNum() {
        return uniqueNum;
    }

    public void setUniqueNum(int uniqueNum) {
        this.uniqueNum = uniqueNum;
    }

    public PhysicalClient getClient() {
        return client;
    }

    public void setClient(PhysicalClient client) {
        this.client = client;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public double getPersonalCost() {
        return personalCost;
    }

    public void setPersonalCost(double personalCost) {
        this.personalCost = personalCost;
    }
}
