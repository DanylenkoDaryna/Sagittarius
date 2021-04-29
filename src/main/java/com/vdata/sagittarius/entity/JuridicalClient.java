package com.vdata.sagittarius.entity;

import java.io.Serializable;

public class JuridicalClient extends Client implements Serializable {

    private String companyName;

    public JuridicalClient() {
    }

    public JuridicalClient(String company) {
        companyName=company;
    }

    @Override
    public String toString() {

        return "Person:" + this.getPersonType() + "\tName:" + this.getCompanyName() +
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
}
