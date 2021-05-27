package com.vdata.sagittarius.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name ="physical_client")
public class PhysicalClient extends Client implements Serializable {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "surname")
    private String surname;

    @OneToOne(mappedBy = "id",  cascade= CascadeType.REMOVE, orphanRemoval = true )
    private Client client;

    /**
     *
     * Constructs a new Client with the default parameters
     * Used for avoiding NullPointerExeption
     */
    public PhysicalClient() {
        client = new Client();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
