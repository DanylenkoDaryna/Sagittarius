package com.vdata.sagittarius.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class PhysicalClient extends Client implements Serializable {

    private String firstName;
    private String midName;
    private String surname;

    /**
     *
     * Constructs a new Client with the default parameters
     * Used for avoiding NullPointerExeption
     */
    public PhysicalClient() {

    }

    @Override
    public String toString() {
        return "Person:" + this.getPersonType().toString() + "\tName:" + this.getFirstName() + " " + this.getMidName()
                + " " + this.getSurname() +"\t Address:" + this.getCity()+", st. "+
                this.getStreet()+";\n";
    }

    @Override
    public boolean equals(Object o) {   // Необходима перегрузка метода!!!
        if (!(o instanceof PhysicalClient))
            return false;
        return ((PhysicalClient)o).getId() == this.id;
    }

    @Override
    public int hashCode() {// Необходима перегрузка метода!!!
        return id;
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


}
