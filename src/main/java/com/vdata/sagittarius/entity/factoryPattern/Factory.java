package com.vdata.sagittarius.entity.factoryPattern;

import com.vdata.sagittarius.entity.Client;
import com.vdata.sagittarius.entity.JuridicalClient;
import com.vdata.sagittarius.entity.PersonType;
import com.vdata.sagittarius.entity.PhysicalClient;

public class Factory {

    public Client createClient(PersonType person){
        Client client = new Client();

        switch (person){
            case PHYSICAL: {
                client = new PhysicalClient();
                client.setPersonType(PersonType.PHYSICAL);
                break;
            }
            case JURIDICAL: {
                client = new JuridicalClient();
                client.setPersonType(PersonType.JURIDICAL);
                break;
            }
        }
        return client;
    }

//    public JuridicalClient createClient(PersonType person){
//            return new JuridicalClient();
//
//    }
//
//    public PhysicalClient createClient(PersonType person){
//            return new PhysicalClient();
//
//    }

    public void someOperation(){

    }
}
