package com.vdata.sagittarius.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="juridical_client")
public class JuridicalClient extends Client implements Serializable {

    @Column(name = "company_name")
    private String companyName;

    @OneToOne(mappedBy = "id",  cascade=CascadeType.REMOVE, orphanRemoval = true )
    private Client client;

    public JuridicalClient() {
    }

    public JuridicalClient(String company) {
        setPersonType(PersonType.JURIDICAL);
        companyName=company;
    }

    @Override
    public String toString() {

        return "Person:" + this.getPersonType().toString() + "\tName:" + this.getCompanyName() +
                "\t Address:" + this.getCity()+", st. "+ this.getStreet()+";\n";


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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
